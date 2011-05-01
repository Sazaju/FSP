/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.conversation;

import java.util.Date;
import org.fsp.definition.util.PersistentData;
import org.fsp.definition.user.UserID;

/**
 * Un message est un texte soumis par quelqu'un (son auteur).
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Message extends PersistentData<MessageID> {
    public UserID getAuthor();
    public Date getDateOfCreation();
    public String getContent();
}
