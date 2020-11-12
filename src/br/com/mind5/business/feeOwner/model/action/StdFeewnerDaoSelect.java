package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeewnerDaoSelect extends ActionStdTemplateV2<FeewnerInfo> {

	public StdFeewnerDaoSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FeewnerInfo> buildVisitorHook(DeciTreeOption<FeewnerInfo> option) {
		return new VisiFeewnerDaoSelect(option);
	}
}
