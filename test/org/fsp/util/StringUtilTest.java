/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fsp.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sazaju HITOKAGE <sazaju[at]gmail.com>
 */
public class StringUtilTest {
    
    @Test
    public void testConcatenate() {
        assertEquals("", StringUtil.concatenate(""));
        assertEquals("1", StringUtil.concatenate("", "1"));
        assertEquals("12", StringUtil.concatenate("", "1", "2"));
        assertEquals("123", StringUtil.concatenate("", "1", "2", "3"));
        
        assertEquals("1", StringUtil.concatenate(" ", "1"));
        assertEquals("1 2", StringUtil.concatenate(" ", "1", "2"));
        assertEquals("1 2 3", StringUtil.concatenate(" ", "1", "2", "3"));
        
        assertEquals(StringUtil.concatenate(""), StringUtil.concatenate(null));
        assertEquals(StringUtil.concatenate("", "1"), StringUtil.concatenate(null, "1"));
        assertEquals(StringUtil.concatenate("", "1", "2"), StringUtil.concatenate(null, "1", "2"));
        assertEquals(StringUtil.concatenate("", "1", "2", "3"), StringUtil.concatenate(null, "1", "2", "3"));
    }
}
