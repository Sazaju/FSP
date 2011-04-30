/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.task;

import java.util.Collection;

/**
 * Une tâche composée est un regroupement de tâches (appelées sous-tâches).
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface ComposedTask extends Task {
    public Collection<TaskID> getTaskIDs(); // TODO remplacer tous les getXxxIDs() par getXxxs()
}
