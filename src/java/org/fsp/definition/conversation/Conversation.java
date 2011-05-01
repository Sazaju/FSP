/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.conversation;

import java.util.Collection;
import org.fsp.definition.util.PersistentData;
import org.fsp.definition.user.UserID;

/**
 * Une conversation est la centralisation de messages générés à l'occasion d'un échange. Cela peut
 * être une discussion en temps réel (chat) ou différée (forum), comme un ensemble de messages
 * envoyés dans un but commun (boîte à idées).
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
// TODO revoir toutes les définitions et mettre la Javadoc pour chaque classe et méthode (cf cahier des charges)
public interface Conversation extends PersistentData<ConversationID> {
    public Collection<MessageID> getMessages();
    public Collection<UserID> getActualContributors();
    public Collection<UserID> getAllContributors();
}
