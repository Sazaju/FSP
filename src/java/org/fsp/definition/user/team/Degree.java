/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user.team;

/**
 * Un degré est le niveau de compétence que peut garantir un membre dans un rôle donné.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public enum Degree {
    TEST,
    SELF_EDUCATED,
    APPRENTICE,
    CERTIFIED;
    
    public boolean isOfficial() {
        return this == APPRENTICE || this == CERTIFIED;
    }
}
