/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.filesystem;

import org.fsp.definition.util.PersistentData;

/**
 * Un fichier est un élément atomique, au sens « ne pouvant être divisé sans perdre de
 * l'information » :<br/>
 * <ul>
 * <li>il est structuré par son type, qui est la sémantique associée au fichier (vidéo, texte, ASS,
 * … un type « indéfini » pour les fichiers complexes peut être utile),</li>
 * <li>son identifiant permet de l'identifier de manière unique (code généré automatiquement et
 * définitivement),</li>
 * <li>son nom permet de l'identifier de manière rapide et sûre (chaîne de caractères définie par
 * l'utilisateur, mais unique, la différence avec l'identifiant étant son caractère modifiable),</li>
 * <li>son contenu détient toute l'information du fichier depuis sa création, en particulier toutes
 * les versions du fichier peuvent être accessibles (seule la dernière est obligatoire, contenu
 * effectif du fichier, les autres peuvent être « purgées » si elles sont jugées inutiles) ; le
 * contenu peut être modifié manuellement (saisie sur le site), automatiquement (modification par le
 * système) ou indirectement (un fichier chargé sur le site pour faire office de nouvelle version)</li>
 * </ul>
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface File extends PersistentData<FileID> {
    public FileType getType();
    public String getName();
    public void setName(String name);
    public byte[] getBytes();
    public void setBytes(byte[] bytes);
    /**
     * Cette méthode applique un diff sur le fichier. Le diff doit bien sûr correspondre au fichier
     * et l'une des versions du diff doit correspondre à la version actuelle du fichier. Selon le
     * diff fourni, le fichier se verra repasser à une version antérieure ou ultérieure (selon que
     * la version actuelle corresponde à la version ultérieure ou antérieure).
     * 
     * @param diff le diff à appliquer
     */
    public void applyDiff(FileDiff diff);
    public FileVersion getVersion();
}
