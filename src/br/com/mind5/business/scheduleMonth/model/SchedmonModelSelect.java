package br.com.mind5.business.scheduleMonth.model;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.decisionTree.RootSchedmonSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedmonModelSelect extends ModelTemplate<SchedmonInfo> {

	public SchedmonModelSelect(SchedmonInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedmonInfo> getDecisionTreeHook(DeciTreeOption<SchedmonInfo> option) {
		return new RootSchedmonSelect(option);
	}
}
