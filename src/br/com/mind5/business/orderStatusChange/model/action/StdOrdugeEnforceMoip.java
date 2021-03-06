package br.com.mind5.business.orderStatusChange.model.action;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdugeEnforceMoip extends ActionStdTemplate<OrdugeInfo> {

	public StdOrdugeEnforceMoip(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdugeInfo> buildVisitorHook(DeciTreeOption<OrdugeInfo> option) {
		return new VisiOrdugeEnforceMoip(option);
	}
}
