package br.com.mind5.masterData.feeCategory.model.action;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeecatDaoSelect extends ActionStdTemplateV2<FeecatInfo> {

	public StdFeecatDaoSelect(DeciTreeOption<FeecatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FeecatInfo> buildVisitorHook(DeciTreeOption<FeecatInfo> option) {
		return new VisiFeecatDaoSelect(option);
	}
}
