/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.fsp.util.StringUtil;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public class DatabaseConnection {

    private final Connection connection;
    private final ManagedDatabases type;

    public DatabaseConnection(ManagedDatabases databaseType, String baseName) {
        switch (databaseType) {
            case SQLITE:
                try {
                    Class.forName("org.sqlite.JDBC");
                }
                catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    connection = DriverManager.getConnection("jdbc:sqlite:" + baseName);
                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            default:
                throw new IllegalArgumentException("base de données non gérée : " + databaseType);
        }

        this.type = databaseType;
    }

    public void executeUpdate(String statement) {
        Statement stat;
        try {
            stat = connection.createStatement();
            stat.executeUpdate(statement);
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void executeInsert(Configuration config) {
        String table = config.getTable();
        String[] columnNames = config.getColumnNames();
        Collection<Object[]> dataArrays = config.getRowsToInsert();

        PreparedStatement prep;
        try {
            String cols = StringUtil.concatenate(",", (Object[]) columnNames);
            prep = connection.prepareStatement(
                    "insert into " + table + " (" + cols + ") values (?, ?);");

            for (Object[] data : dataArrays) {
                for (int index = 0; index < data.length; index++) {
                    Object value = data[index];
                    if (value instanceof String) {
                        prep.setString(index + 1, (String) value);
                    }
                    else {
                        throw new IllegalArgumentException("type d'élément non géré : " + value.
                                getClass());
                    }
                }
                prep.addBatch();
            }
            connection.setAutoCommit(false);
            prep.executeBatch();
            connection.setAutoCommit(true);
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Collection<Object[]> executeQuery(Configuration config) {
        String table = config.getTable();
        String[] columnNames = config.getColumnNames();
        Map<String, Collection<Object>> constraints = config.getConstraints();

        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        Statement stat;
        ResultSet rs;
        try {
            stat = connection.createStatement();
            String colums = columnNames == null || columnNames.length == 0 ?
                            "*" :
                            StringUtil.concatenate(",", (Object[]) columnNames);
            Collection<String> list1 = new ArrayList<String>();
            for (Map.Entry<String, Collection<Object>> entry : constraints.entrySet()) {
                String columnName = entry.getKey();
                Collection<String> list2 = new ArrayList<String>();
                for (Object value : entry.getValue()) {
                    if (value instanceof String) {
                        list2.add("'" + value.toString() + "'");
                    }
                    else {
                        throw new IllegalArgumentException("type non géré : " + value.getClass());
                    }
                }
                list1.add(columnName + " in (" + StringUtil.concatenate(",", list2.toArray()) + ")");
            }

            rs = stat.executeQuery(
                    "select " + colums + " from " + table + (list1.isEmpty() ? "" :
                                                             " where " + StringUtil.concatenate(
                    " and ", list1.toArray())) + ";");

            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int index = 0; index < columnCount; index++) {
                    int colIndex = index + 1;
                    int columnType = rs.getMetaData().getColumnType(colIndex);
                    Object value = null;
                    switch (columnType) {
                        case java.sql.Types.CHAR:
                        case java.sql.Types.VARCHAR:
                            value = rs.getString(colIndex);
                            break;
                        default:
                            throw new IllegalStateException("type non géré : " + columnType);
                    }
                    row[index] = value;
                }
                rows.add(row);
            }
            rs.close();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return rows;
    }

    public boolean isClosed() {
        try {
            return connection.isClosed();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Ferme la connection si elle ne l'est pas déjà (sinon ne fait rien). Cette méthode est appelée
     * automatiquement à la destruction de l'objet, son appel n'est donc pas nécessaire dans la
     * plupart des cas.
     */
    public void close() {
        if (!isClosed()) {
            try {
                connection.close();
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public static class Configuration {

        private String table;
        private final ArrayList<String> columnNames = new ArrayList<String>();
        private final Collection<Object[]> rows = new ArrayList<Object[]>();
        private final Map<String, Collection<Object>> constraints =
                                                      new HashMap<String, Collection<Object>>();

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public String[] getColumnNames() {
            return columnNames.toArray(new String[0]);
        }

        public void addColumnNames(String... names) {
            if (names == null) {
                throw new NullPointerException("le nom de colonne ne peut être null");
            }
            columnNames.addAll(Arrays.asList(names));
        }

        public Collection<Object[]> getRowsToInsert() {
            return rows;
        }

        public void addRowToInsert(Object[] row) {
            rows.add(row);
        }

        public Map<String, Collection<Object>> getConstraints() {
            return constraints;
        }

        public void addConstraint(String column, Object... possibleValues) {
            Collection<Object> values = constraints.get(column);
            if (values == null) {
                values = new HashSet<Object>();
                constraints.put(column, values);
            }
            values.addAll(Arrays.asList(possibleValues));
        }
    }
}
