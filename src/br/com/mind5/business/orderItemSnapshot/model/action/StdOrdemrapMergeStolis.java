package br.com.mind5.business.orderItemSnapshot.model.action;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemrapMergeStolis extends ActionStdTemplate<OrdemrapInfo> {

	public StdOrdemrapMergeStolis(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdemrapInfo> buildVisitorHook(DeciTreeOption<OrdemrapInfo> option) {
		return new VisiOrdemrapMergeStolis(option);
	}
}
