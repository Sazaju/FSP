/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.organisation;

import org.fsp.definition.user.UserID;

/**
 * Un rapport personnel est un rapport adapté à un membre particulier, listant tous les points dont
 * il doit prendre connaissance (qui ont changé depuis le dernier rapport), son contenu change donc
 * en fonction du lecteur.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface PersonalReport {
    public UserID getRecipientID();
}
