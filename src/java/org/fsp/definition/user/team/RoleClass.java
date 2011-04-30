/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.user.team;

/**
 * Une classe est une catégorie spécifique de compétence. Chaque classe est associée à un rôle
 * ({@link Role}) et à un degré ({@link Degree}). Les classes d'un même rôle et d'un même degré sont
 * ordonnées selon une logique propre aux besoins de l'équipe.
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface RoleClass extends Comparable<RoleClass> {
    
}
