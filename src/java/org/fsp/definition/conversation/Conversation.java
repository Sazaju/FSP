/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.conversation;

import java.util.Collection;
import org.fsp.definition.PersistentData;
import org.fsp.definition.user.UserID;

/**
 * Une conversation est la centralisation de messages générés à l'occasion d'un échange. Cela peut
 * être une discussion en temps réel (chat) ou différée (forum), comme un ensemble de messages
 * envoyés dans un but commun (boîte à idées).
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Conversation extends PersistentData<ConversationID> {
    public Collection<MessageID> getMessageIDs();
    public Collection<UserID> getActualContributorIDs();
    public Collection<UserID> getAllContributorIDs();
}
