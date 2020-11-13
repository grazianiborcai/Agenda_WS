package br.com.mind5.business.storeWorkTimeRange.model.action;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoworgDaoSelect extends ActionStdTemplateV2<StoworgInfo> {

	public StdStoworgDaoSelect(DeciTreeOption<StoworgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoworgInfo> buildVisitorHook(DeciTreeOption<StoworgInfo> option) {
		return new VisiStoworgDaoSelect(option);
	}
}
