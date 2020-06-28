package br.com.mind5.business.companySnapshot.model.action;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompnapDaoInsert extends ActionStdTemplateV2<CompnapInfo> {

	public StdCompnapDaoInsert(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CompnapInfo> buildVisitorHook(DeciTreeOption<CompnapInfo> option) {
		return new VisiCompnapDaoInsert(option);
	}
}
