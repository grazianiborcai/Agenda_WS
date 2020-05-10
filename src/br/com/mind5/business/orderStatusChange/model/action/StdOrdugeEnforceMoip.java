package br.com.mind5.business.orderStatusChange.model.action;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdugeEnforceMoip extends ActionStdTemplateV2<OrdugeInfo> {

	public StdOrdugeEnforceMoip(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdugeInfo> buildVisitorHook(DeciTreeOption<OrdugeInfo> option) {
		return new VisiOrdugeEnforceMoip(option);
	}
}
