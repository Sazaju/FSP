/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.task;

import java.util.Collection;
import org.fsp.definition.user.UserID;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface ManualTask extends AtomicTask {
    public Collection<UserID> getAssignedUserIDs();
    /**
     * 
     * @return la description détaillée de la tâche à effectuer
     */
    public String getDescription();
}
