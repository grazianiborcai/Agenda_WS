package br.com.mind5.business.employeeLeaveDateRange.model.action;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplargDaoSelect extends ActionStdTemplateV2<EmplargInfo> {

	public StdEmplargDaoSelect(DeciTreeOption<EmplargInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmplargInfo> buildVisitorHook(DeciTreeOption<EmplargInfo> option) {
		return new VisiEmplargDaoSelect(option);
	}
}

