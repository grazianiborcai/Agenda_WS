package br.com.mind5.business.companySearch.model.action;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComparchMergeToSelect extends ActionStdTemplateV2<ComparchInfo> {

	public StdComparchMergeToSelect(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<ComparchInfo> buildVisitorHook(DeciTreeOption<ComparchInfo> option) {
		return new VisiComparchMergeToSelect(option);
	}
}
