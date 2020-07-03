package br.com.mind5.business.customerSnapshot.model.action;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusnapDaoInsert extends ActionStdTemplateV2<CusnapInfo> {

	public StdCusnapDaoInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusnapInfo> buildVisitorHook(DeciTreeOption<CusnapInfo> option) {
		return new VisiCusnapDaoInsert(option);
	}
}
