/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.task;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface AutomaticTask extends AtomicTask {
    /**
     * Cette méthode doit prendre en charge l'intégrlaité de l'exécution de la tâche. On considère
     * qu'elle est appliquée lorsque toutes les entrées nécessaires sont fournies.
     */
    public void execute();
}
