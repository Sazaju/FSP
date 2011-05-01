/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.util;

/**
 * Un ID est une donnée associée à un type d'élément particulier. Chaque élément dispose d'un ID, et
 * chaque ID est unique.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface IDManager<ElementType> {

    /**
     * 
     * @return la valeur de l'ID
     */
    public Object getValue();
    
    /**
     * 
     * @return l'objet disposant de cet ID
     */
    public ElementType getElement();
}
