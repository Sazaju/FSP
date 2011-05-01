/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.definition.filesystem;

import java.util.Collection;
import org.fsp.definition.util.PersistentData;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public interface Section extends PersistentData<SectionID> {
    public Collection<FileID> getFiles();
    public Collection<SectionID> getSections();
}
