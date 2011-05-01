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
    public Collection<UserID> getAuthorizedUsers();
    public void addAuthorizedUser(UserID id);
    public void removeAuthorizedUser(UserID id);
}
