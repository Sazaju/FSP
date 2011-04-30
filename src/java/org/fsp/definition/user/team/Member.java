/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user.team;

import org.fsp.definition.user.ConnectedUser;

/**
 * Un membre est un connecté ayant au moins un rôle de degré officiel supérieur à essai.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Member extends TeamUser {
    public void setToApprenticeDegreeIn(Role role);
    public void setToCertifiedDegreeIn(Role role);
    public void setToAutodidactDegreeIn(Role role);
    public boolean isTeamLeader();
}
