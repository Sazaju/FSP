/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.organisation;

/**
 * Un rapport thématique est un rapport sur un sujet précis (une tâche, un projet, les informations
 * d'un membre, …) et accessible depuis l'objet du rapport (la tâche, le projet, le membre, …), son
 * contenu change donc en fonction du sujet traité.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface ThematicReport<SourceType> extends Report {
    public SourceType getSource();
}
