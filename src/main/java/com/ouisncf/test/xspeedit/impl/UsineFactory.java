package com.ouisncf.test.xspeedit.impl;

import com.ouisncf.test.xspeedit.impl.Robot;

/**
 * Interface Usine, permettaant de creer des robots
 * 
 * @author crabiller
 *
 */

public interface UsineFactory {

  /**
   * Methode de création d'un robot sans parametres. Une configuration par defaut
   * est appliqué au robot (Voir Constants.java)
   * 
   * @return le robot créé
   */
  abstract Robot createRobot();

  /**
   * Méthode de création d'un robot avec un type de carton spécifié
   * 
   * @param typeCarton
   * @return le robot créé
   */
  abstract Robot createRobot(Carton typeCarton);

}
