/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.task;

import java.util.Collection;

/**
 * Une tâche atomique est une tâche où l'opération a effectuer ne peut pas être divisée en plusieurs
 * tâches.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface AtomicTask extends Task {
    public String getName();
    public Collection<TaskConstraint> getConstraints();
}
