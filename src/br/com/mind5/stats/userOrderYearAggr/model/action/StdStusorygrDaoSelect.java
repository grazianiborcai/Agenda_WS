package br.com.mind5.stats.userOrderYearAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrInfo;

public final class StdStusorygrDaoSelect extends ActionStdTemplate<StusorygrInfo> {

	public StdStusorygrDaoSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygrInfo> buildVisitorHook(DeciTreeOption<StusorygrInfo> option) {
		return new VisiStusorygrDaoSelect(option);
	}
}
