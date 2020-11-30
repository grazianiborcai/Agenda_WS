package br.com.mind5.business.scheduleWeek.model;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.decisionTree.RootSchedeekSelectNext;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekModelSelectNext extends ModelTemplate<SchedeekInfo> {

	public SchedeekModelSelectNext(SchedeekInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedeekInfo> getDecisionTreeHook(DeciTreeOption<SchedeekInfo> option) {
		return new RootSchedeekSelectNext(option);
	}
}
