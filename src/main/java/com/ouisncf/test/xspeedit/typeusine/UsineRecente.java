package com.ouisncf.test.xspeedit.typeusine;

import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.UsineFactory;
import com.ouisncf.test.xspeedit.typecarton.MoyenCarton;
import com.ouisncf.test.xspeedit.typerobot.RobotAncien;
import com.ouisncf.test.xspeedit.typerobot.RobotRecent;

/**
 * Usine recente , fabriquant des robots en carbon à la pointe de la technologie
 * Cette usine peut aussi fabriquer des robots anciens
 * 
 * @author crabiller
 *
 */

public class UsineRecente implements UsineFactory {

  /**
   * Permet de creer un nouveau robot avec une configuration par defaut (carton
   * moyen)
   */
  public Robot createRobot() {
    Robot robot = new RobotRecent(new MoyenCarton());
    return robot;
  }

  /**
   * Permet de creer un ancien robot avec une configuration par defaut (carton
   * moyen)
   */
  public Robot createRobotAncien() {
    Robot robot = new RobotAncien(new MoyenCarton());
    return robot;
  }

  /**
   * Permet de creer un nouveau robot avec une configuration donnée
   * 
   * @param typeCarton
   *          type de carton traité par le robot
   * @return le robot
   */
  public Robot createRobot(Carton typeCarton) {
    Robot robot = new RobotRecent(typeCarton);
    return robot;
  }

  /**
   * Permet de creer un ancien robot avec une configuration donnée
   * 
   * @param typeCarton
   *          type de carton traité par le robot
   * @return le robot
   */
  public Robot createRobotAncien(Carton typeCarton) {
    Robot robot = new RobotAncien(typeCarton);
    return robot;
  }

}
