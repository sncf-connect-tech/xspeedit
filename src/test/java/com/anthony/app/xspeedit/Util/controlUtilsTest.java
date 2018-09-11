package com.anthony.app.xspeedit.Util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import com.anthony.app.xspeedit.exception.InvalidEntryException;

public class controlUtilsTest {

    /**
     * Test la méthode IsValidEntry avec des cas passants
     * Les exeptions peuvent aussi être testées par annotation (@expected ..)
     * @return
     * @throws InvalidEntryException 
     */
    public void testIsValidEntryOk(){
    	try {
			assertTrue(ControlUtils.isValidEntry("1"));
		} catch (InvalidEntryException e1) {
			fail("Cette entrée devrait être valide");
		}
    	try {
			assertTrue(ControlUtils.isValidEntry("3"));
		} catch (InvalidEntryException e1) {
			fail("Cette entrée devrait être valide");

		}
    	try {
			assertTrue(ControlUtils.isValidEntry("8"));
		} catch (InvalidEntryException e1) {
			fail("Cette entrée devrait être valide");

		}
    	try {
			assertTrue(ControlUtils.isValidEntry("9"));
		} catch (InvalidEntryException e1) {
			fail("Cette entrée devrait être valide");
		}
    }
    
    // Tests de levées d'exception
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoBorne1() throws InvalidEntryException {
    	ControlUtils.isValidEntry("0");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoBorne2() throws InvalidEntryException {
    	ControlUtils.isValidEntry("10");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoDecimal() throws InvalidEntryException {
    	ControlUtils.isValidEntry("2.2");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryGrandNombre() throws InvalidEntryException {
    	ControlUtils.isValidEntry("99999");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoPonctuation() throws InvalidEntryException {
    	ControlUtils.isValidEntry("./");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoLettre() throws InvalidEntryException {
    	ControlUtils.isValidEntry("A");
    }
  
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoNegatifDansBorne() throws InvalidEntryException {
    	ControlUtils.isValidEntry("-2");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoNegatifHorsBorne() throws InvalidEntryException {
    	ControlUtils.isValidEntry("-20");
    }
    
    @Test(expected = InvalidEntryException.class)
    public void testInvalidEntryKoGrandNegatif() throws InvalidEntryException {
    	ControlUtils.isValidEntry("-2000000");
    }
         
}
