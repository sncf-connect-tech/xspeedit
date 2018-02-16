package com.ouisncf.test.xspeedit.typecarton;

import com.ouisncf.test.xspeedit.constant.Constant;
import com.ouisncf.test.xspeedit.impl.Carton;

/**
 * Classe concrete representant un Grand Carton
 * 
 * @author crabiller
 *
 */

public class GrandCarton extends Carton {

  /**
   * Constructeur par defaut
   */
  public GrandCarton() {
    this.taille = Constant.TAILLE_CARTON_GRANDE;
  }

}
