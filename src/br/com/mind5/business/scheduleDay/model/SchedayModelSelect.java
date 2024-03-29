package br.com.mind5.business.scheduleDay.model;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.decisionTree.SchedayRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedayModelSelect extends ModelTemplate<SchedayInfo> {

	public SchedayModelSelect(SchedayInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedayInfo> getDecisionTreeHook(DeciTreeOption<SchedayInfo> option) {
		return new SchedayRootSelect(option);
	}
}
