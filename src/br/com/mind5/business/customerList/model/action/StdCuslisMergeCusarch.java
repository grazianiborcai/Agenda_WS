package br.com.mind5.business.customerList.model.action;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCuslisMergeCusarch extends ActionStdTemplateV2<CuslisInfo> {

	public StdCuslisMergeCusarch(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CuslisInfo> buildVisitorHook(DeciTreeOption<CuslisInfo> option) {
		return new VisiCuslisMergeCusarch(option);
	}
}
