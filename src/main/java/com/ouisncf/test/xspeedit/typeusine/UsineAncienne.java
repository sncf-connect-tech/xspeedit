package com.ouisncf.test.xspeedit.typeusine;

import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.UsineFactory;
import com.ouisncf.test.xspeedit.typecarton.MoyenCarton;
import com.ouisncf.test.xspeedit.typerobot.RobotAncien;



/**
 * Usine ancienne , fabriquant seulement des robots en feraille ayant 10 ans de retard
 * 
 * 
 * @author crabiller
 *
 */

public class UsineAncienne implements UsineFactory {


  /**
   * Permet de creer un ancien robot avec une configuration par defaut (carton
   * moyen)
   */
	public Robot createRobot() {
		Robot robot = new RobotAncien(new MoyenCarton());
		return robot;
	}

	/**
  * Permet de creer un ancien robot avec une configuration donnée
  * 
  * @param typeCarton
  *          type de carton traité par le robot
  * @return le robot
  */
	
	public Robot createRobot(Carton typeCarton) {
		Robot robot = new RobotAncien(typeCarton);
		return robot;
	}

}


