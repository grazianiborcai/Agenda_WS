package br.com.mind5.business.storeWorkTimeRange.model.action;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoworgDaoSelect extends ActionStdTemplate<StoworgInfo> {

	public StdStoworgDaoSelect(DeciTreeOption<StoworgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoworgInfo> buildVisitorHook(DeciTreeOption<StoworgInfo> option) {
		return new VisiStoworgDaoSelect(option);
	}
}
