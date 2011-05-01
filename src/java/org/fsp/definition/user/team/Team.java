/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user.team;

import java.util.Collection;
import org.fsp.definition.user.UserID;

/**
 * Une équipe est un ensemble de membre s'activant dans l'objectif d'exercer une activité commune.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Team {
    public String getName();
    public Collection<UserID> getMembers();
}
