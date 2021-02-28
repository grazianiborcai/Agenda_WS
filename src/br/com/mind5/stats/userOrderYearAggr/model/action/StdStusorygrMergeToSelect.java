package br.com.mind5.stats.userOrderYearAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrInfo;

public final class StdStusorygrMergeToSelect extends ActionStdTemplate<StusorygrInfo> {

	public StdStusorygrMergeToSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygrInfo> buildVisitorHook(DeciTreeOption<StusorygrInfo> option) {
		return new VisiStusorygrMergeToSelect(option);
	}
}
