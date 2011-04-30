/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.task;

import java.util.Collection;
import org.fsp.definition.PersistentData;

/**
 * Une tâche est une action à effectuer.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Task extends PersistentData<TaskID> {
    public Collection<TaskInput> getInputs();
    public Collection<TaskOutput> getOutputs();
    public TaskState getState();
}
