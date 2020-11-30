package br.com.mind5.business.scheduleRange.model;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.decisionTree.RootSchedageSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedageModelSelect extends ModelTemplate<SchedageInfo> {

	public SchedageModelSelect(SchedageInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedageInfo> getDecisionTreeHook(DeciTreeOption<SchedageInfo> option) {
		return new RootSchedageSelect(option);
	}
}
