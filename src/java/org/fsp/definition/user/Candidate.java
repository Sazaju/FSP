/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user;

import java.util.Collection;
import org.fsp.definition.user.team.Role;

/**
 * Un candidat est un connecté souhaitant intégrer l'équipe de Fansub pour des rôles particuliers.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Candidate extends ConnectedUser {

    public Collection<Role> getAskedRoles();
}
