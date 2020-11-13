package br.com.mind5.business.companySearch.model.action;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComparchDaoSelect extends ActionStdTemplate<ComparchInfo> {

	public StdComparchDaoSelect(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<ComparchInfo> buildVisitorHook(DeciTreeOption<ComparchInfo> option) {
		return new VisiComparchDaoSelect(option);
	}
}
