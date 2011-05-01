/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.util;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public class StringUtil {
    /**
     * Cette méthode permet d'effectuer facilement un listage sur un ensemble d'objets.
     * 
     * @param separator séparateur à placer entre les éléments (<code>null</code> == "")
     * @param values objets à lister
     * @return une chaîne listant chacun des objets, séparés par le séparateur
     */
    public static String concatenate(String separator, Object... values) {
        if (separator == null) {
            separator = "";
        }
        
        String result = "";
        for(Object value : values) {
            result += separator + value.toString();
        }
        return result.substring(separator.length());
    }
}
