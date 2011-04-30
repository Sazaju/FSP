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
public interface PublicConversation {
    public Collection<UserID> getBannedUserIDs();
    public void addBannedUserID(UserID id);
    public void removeBannedUserID(UserID id);
}
