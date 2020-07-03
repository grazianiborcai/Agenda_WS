package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompEnforceNameSearch extends ActionStdTemplateV2<CompInfo> {

	public StdCompEnforceNameSearch(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CompInfo> buildVisitorHook(DeciTreeOption<CompInfo> option) {
		return new VisiCompEnforceNameSearch(option);
	}
}
