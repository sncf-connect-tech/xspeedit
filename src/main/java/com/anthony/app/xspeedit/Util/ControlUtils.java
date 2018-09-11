package com.anthony.app.xspeedit.Util;

import org.apache.commons.lang3.StringUtils;

import com.anthony.app.xspeedit.constant.Constant;
import com.anthony.app.xspeedit.exception.InvalidEntryException;

/**
 * Classe utilitaire comportant l'ensemble des controles de saisie utilisateur
 * @author aarchamb
 *
 */
public class ControlUtils {

	 /**
     * Retourne vrai si l'entrée est un chiffre entre 1 et 9, sinon genère une exeption
     * @param entry
     * @return
     */
    public static boolean isValidEntry(String entry) throws InvalidEntryException {
    	if(!entry.matches("^[1-9]$")) {
    		throw  new InvalidEntryException("Votre saisie est invalide. "
    				+ "Veuillez saisir un chifre entre 1 et 9 : ");
    	}
    	return entry.matches("^[1-9]$");
    }
 
    /**
     * Retourne vrai si l'utilisateur souhaite arrêter de saisir
     * (chaine vide)
     * @param entry
     * @return
     */
    public static boolean isStopping(String entry) {
    	return StringUtils.isEmpty(entry);
    }
}
