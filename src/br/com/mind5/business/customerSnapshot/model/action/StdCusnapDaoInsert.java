package br.com.mind5.business.customerSnapshot.model.action;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusnapDaoInsert extends ActionStdTemplate<CusnapInfo> {

	public StdCusnapDaoInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusnapInfo> buildVisitorHook(DeciTreeOption<CusnapInfo> option) {
		return new VisiCusnapDaoInsert(option);
	}
}
