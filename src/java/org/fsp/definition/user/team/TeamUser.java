/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user.team;

import java.util.Collection;
import org.fsp.definition.user.ConnectedUser;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface TeamUser extends ConnectedUser {
    public Collection<Role> getRoles();
    public Degree getDegreeFor(Role role);
    public RoleClass getClassFor(Role role);
}
