/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.database;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import org.fsp.database.DatabaseConnection.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public class DatabaseConnectionTest {

    private static final String BASEFILE = "test.db";
    private static DatabaseConnection connection;

    @BeforeClass
    public static void setup() {
        deleteBase();
        System.out.println("création de la base de test " + BASEFILE + "...");
        connection = new DatabaseConnection(ManagedDatabases.SQLITE, BASEFILE);
        System.out.println("base créée");
    }

    @AfterClass
    public static void setdown() {
        connection.close();
        deleteBase();
    }

    private static void deleteBase() {
        File databaseFile = new File(BASEFILE);
        if (databaseFile.exists()) {
            System.out.println("suppression de la base de test " + BASEFILE + "...");
            boolean deleted = databaseFile.delete();
            if (deleted) {
                System.out.println("base supprimée");
            }
            else {
                throw new IllegalStateException("impossible d'effacer la base " + BASEFILE);
            }
        }
    }

    @Test
    public void testInsert() {
        String table = "testMultipleInsert";
        String col1 = "name";
        String col2 = "occupation";

        {
            connection.executeUpdate("create table " + table + " (" + col1 + ", " + col2 + ");");
            Configuration config = new Configuration();
            config.setTable(table);
            config.addColumnNames(col1, col2);
            config.addRowToInsert(new String[]{"Gandhi", "politics"});
            config.addRowToInsert(new String[]{"Turing", "computers"});
            config.addRowToInsert(new String[]{"Wittgenstein", "smartypants"});
            connection.executeInsert(config);
        }

        {
            Configuration config = new Configuration();
            config.setTable(table);
            config.addColumnNames(col1, col2);
            Collection<Object[]> rows = connection.executeQuery(config);
            assertEquals(3, rows.size());
            for (Object[] row : rows) {
                if (row[0].equals("Gandhi")) {
                    assertEquals("politics", row[1]);
                }
                else if (row[0].equals("Turing")) {
                    assertEquals("computers", row[1]);
                }
                else if (row[0].equals("Wittgenstein")) {
                    assertEquals("smartypants", row[1]);
                }
                else {
                    fail("enregistrement non attendu : " + Arrays.deepToString(row));
                }
            }
        }
    }

    @Test
    public void testSelect() {
        String table = "testSelect";
        String col1 = "name";
        String col2 = "occupation";

        {
            connection.executeUpdate("create table " + table + " (" + col1 + ", " + col2 + ");");
            Configuration config = new Configuration();
            config.setTable(table);
            config.addColumnNames(col1, col2);
            config.addRowToInsert(new String[]{"Gandhi", "politics"});
            config.addRowToInsert(new String[]{"Turing", "computers"});
            config.addRowToInsert(new String[]{"Wittgenstein", "smartypants"});
            connection.executeInsert(config);
        }

        {
            Configuration config = new Configuration();
            config.setTable(table);
            config.addColumnNames(col1, col2);
            config.addConstraint(col1, "Turing");
            Collection<Object[]> rows = connection.executeQuery(config);
            assertEquals(1, rows.size());
            Object[] row = rows.iterator().next();
            assertEquals("Turing", row[0]);
            assertEquals("computers", row[1]);
        }

        {
            Configuration config = new Configuration();
            config.setTable(table);
            config.addColumnNames(col1, col2);
            config.addConstraint(col2, "computers");
            Collection<Object[]> rows = connection.executeQuery(config);
            assertEquals(1, rows.size());
            Object[] row = rows.iterator().next();
            assertEquals("Turing", row[0]);
            assertEquals("computers", row[1]);
        }

        {
            Configuration config = new Configuration();
            config.setTable(table);
            config.addColumnNames(col1, col2);
            config.addConstraint(col2, "computers", "smartypants");
            Collection<Object[]> rows = connection.executeQuery(config);
            assertEquals(2, rows.size());
            for (Object[] row : rows) {
                if (row[0].equals("Turing")) {
                    assertEquals("computers", row[1]);
                }
                else if (row[0].equals("Wittgenstein")) {
                    assertEquals("smartypants", row[1]);
                }
                else {
                    fail("enregistrement non attendu : " + Arrays.deepToString(row));
                }
            }
        }
    }
}
