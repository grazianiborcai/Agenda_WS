package br.com.mind5.business.orderStatusChange.model.action;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdugeEnforceRefunding extends ActionStdTemplate<OrdugeInfo> {

	public StdOrdugeEnforceRefunding(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdugeInfo> buildVisitorHook(DeciTreeOption<OrdugeInfo> option) {
		return new VisiOrdugeEnforceRefunding(option);
	}
}
