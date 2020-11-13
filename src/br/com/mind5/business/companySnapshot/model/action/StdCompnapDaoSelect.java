package br.com.mind5.business.companySnapshot.model.action;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompnapDaoSelect extends ActionStdTemplate<CompnapInfo> {

	public StdCompnapDaoSelect(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CompnapInfo> buildVisitorHook(DeciTreeOption<CompnapInfo> option) {
		return new VisiCompnapDaoSelect(option);
	}
}
