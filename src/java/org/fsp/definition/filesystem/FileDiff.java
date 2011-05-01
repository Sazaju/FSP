/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.filesystem;

/**
 * Un diff de fichier est une différence calculée entre deux versions d'un même fichier. Si on
 * applique cette différence à la version antérieure, on retrouve la version ultérieure, et
 * inversement.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface FileDiff {
    public FileID getFile();
    public FileVersion getPreviousVersion();
    public FileVersion getNextVersion();
    /* TODO étudier le diff :
     * - appliqué sur l'ancienne version ça donne la nouvelle
     * - appliqué sur la nouvelle version ça donne l'ancienne
     * - une A vers B combinée à une B vers C donne une A vers C
     */
    public Object getDiff();
}
