/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.organisation;

import org.fsp.definition.PersistentData;

/**
 * Un rapport a pour objectif de centraliser les informations qui intéressent les membres, et
 * uniquement cela (pas de message « générique » où chacun doit chercher ce qui l'intéresse).
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Report extends PersistentData<ReportID> {
    public String getContent();
}
