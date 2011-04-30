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
    public FileID getFileID();
    public VersionID getPreviousVersionID();
    public VersionID getNextVersionID();
    public Object getDiff(); // TODO étudier cette partie
}
