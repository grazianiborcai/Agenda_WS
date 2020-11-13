package br.com.mind5.business.storeLeaveDateRange.model.action;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolargDaoSelect extends ActionStdTemplate<StolargInfo> {

	public StdStolargDaoSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StolargInfo> buildVisitorHook(DeciTreeOption<StolargInfo> option) {
		return new VisiStolargDaoSelect(option);
	}
}

