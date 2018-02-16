package com.ouisncf.test.xspeedit.typecarton;

import com.ouisncf.test.xspeedit.constant.Constant;
import com.ouisncf.test.xspeedit.impl.Carton;

/**
 * 
 * Classe concrete representant un carton moyen
 * 
 * @author crabiller
 *
 */
public class MoyenCarton extends Carton {

  /**
   * Constructeur par defaut
   */
  public MoyenCarton() {
    this.taille = Constant.TAILLE_CARTON_MOYENNE;
  }

}
