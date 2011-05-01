/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user;

import org.fsp.definition.util.PersistentData;

/**
 * Un connecté est un internaute inscrit sur le site.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface ConnectedUser extends InternetUser, PersistentData<UserID> {
    public String getName();
    public String getPasswordHash();
    public String getMailAddress();
}
