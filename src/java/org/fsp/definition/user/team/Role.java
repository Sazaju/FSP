/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user.team;

import java.util.Collection;

/**
 * Un rôle définit une fonction que joue un membre dans l'équipe. Les rôles disponibles sont
 * définis par l'équipe elle-même.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Role {
    public Collection<RoleClass> getApprenticeClasses();
    public Collection<RoleClass> getCertifiedClasses();
}
