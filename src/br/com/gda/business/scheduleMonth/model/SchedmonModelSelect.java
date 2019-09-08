package br.com.gda.business.scheduleMonth.model;

import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleMonth.model.decisionTree.RootSchedmonSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SchedmonModelSelect extends ModelTemplate<SchedmonInfo> {

	public SchedmonModelSelect(SchedmonInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedmonInfo> getDecisionTreeHook(DeciTreeOption<SchedmonInfo> option) {
		return new RootSchedmonSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
