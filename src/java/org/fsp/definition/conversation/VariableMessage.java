/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.conversation;

import java.util.Collection;
import java.util.Date;

/**
 * Un message variable est un message pouvant être modifié.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface VariableMessage extends Message {
    public void setContent(String content);
    public Date getDateOfLastModification();
    public Collection<MessageID> getHistory();
}
