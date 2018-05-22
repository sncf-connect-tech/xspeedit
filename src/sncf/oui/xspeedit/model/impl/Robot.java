package sncf.oui.xspeedit.model.impl;

import java.util.ArrayList;
import java.util.List;

import sncf.oui.xspeedit.model.IArticle;
import sncf.oui.xspeedit.model.ICarton;
import sncf.oui.xspeedit.model.IRobot;
/**
 * 
 * @author Malik
 *
 */
public class Robot implements IRobot{

	@Override
	public List<ICarton> rangerArticles(List<IArticle> articles) {
		List<ICarton> cartons = new ArrayList<>();
		for(IArticle article : articles) {
			boolean articleRange = false;
			for(ICarton carton : cartons) {
				if(carton.canAddArticle(article)) {
					articleRange = true;
					carton.getArticles().add(article);
					break;
				}
			}
			if(!articleRange) {
				cartons.add(new Carton(article));
			}
		}
		return cartons;
	}
		
}
