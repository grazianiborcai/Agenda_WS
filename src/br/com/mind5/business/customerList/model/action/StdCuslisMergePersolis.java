package br.com.mind5.business.customerList.model.action;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdCuslisMergePersolis extends ActionStdTemplateV2<CuslisInfo> {

	public StdCuslisMergePersolis(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CuslisInfo> buildVisitorHook(DeciTreeOption<CuslisInfo> option) {
		return new VisiCuslisMergePersolis(option);
	}
}
