/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.filesystem;

import java.util.Collection;
import org.fsp.definition.PersistentData;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Section extends PersistentData<SectionID> {
    public Collection<FileID> getFileIDs();
    public Collection<SectionID> getSectionIDs();
}
