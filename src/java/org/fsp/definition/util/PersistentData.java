/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.util;

/**
 * Une donnée persistente est une donnée étant sauvegardée. Cela implique qu'on soit capable de la
 * récupérer depuis là où elle est écrite (fichier, base de données, ...). Pour cela, il faut être
 * capable de l'identifier, chaque donnée doit donc disposer d'un identifiant unique et non
 * modifiable.
 * 
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface PersistentData<IDType extends IDManager> {
    /**
     * 
     * @return un identifiant unique et non modifiable, propre à cet élément.
     */
    public IDType getID();
    /**
     * Cette méthode permet de sauvegarder les modifications apportées à l'élément de manière
     * persistente.
     */
    public void save();
    /**
     * Cette méthode permet de remplacer les données actuelles de l'élément par les dernières
     * données sauvegardées.
     */
    public void load();
}
