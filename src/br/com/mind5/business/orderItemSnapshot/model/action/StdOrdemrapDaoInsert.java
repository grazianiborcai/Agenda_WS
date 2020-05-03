package br.com.mind5.business.orderItemSnapshot.model.action;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemrapDaoInsert extends ActionStdTemplateV2<OrdemrapInfo> {

	public StdOrdemrapDaoInsert(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdemrapInfo> buildVisitorHook(DeciTreeOption<OrdemrapInfo> option) {
		return new VisiOrdemrapDaoInsert(option);
	}
}
