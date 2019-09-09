package br.com.gda.business.scheduleWeek.model;

import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.business.scheduleWeek.model.decisionTree.RootSchedeekSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SchedeekModelSelect extends ModelTemplate<SchedeekInfo> {

	public SchedeekModelSelect(SchedeekInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedeekInfo> getDecisionTreeHook(DeciTreeOption<SchedeekInfo> option) {
		return new RootSchedeekSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
