/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.project;

import java.util.Collection;
import org.fsp.definition.util.PersistentData;
import org.fsp.definition.task.TaskID;
import org.fsp.definition.user.UserID;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Project extends PersistentData<ProjectID> {
    public String getTitle();
    public String getDescription();
    public TaskID getTask();
    public Collection<UserID> getUsersInCharge();
}
