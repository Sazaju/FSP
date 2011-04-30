/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.conversation;

import java.util.Collection;
import org.fsp.definition.user.UserID;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface PrivateConversation {
    public Collection<UserID> getAuthorizedUserIDs();
    public void addAuthorizedUserID(UserID id);
    public void removeAuthorizedUserID(UserID id);
}
