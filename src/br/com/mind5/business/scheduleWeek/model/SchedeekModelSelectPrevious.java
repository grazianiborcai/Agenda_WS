package br.com.mind5.business.scheduleWeek.model;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.decisionTree.RootSchedeekSelectPrevious;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekModelSelectPrevious extends ModelTemplate<SchedeekInfo> {

	public SchedeekModelSelectPrevious(SchedeekInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedeekInfo> getDecisionTreeHook(DeciTreeOption<SchedeekInfo> option) {
		return new RootSchedeekSelectPrevious(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
