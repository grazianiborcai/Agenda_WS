package br.com.mind5.business.storeSearch.model.action;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSotarchMergeToSelect extends ActionStdTemplateV2<SotarchInfo> {

	public StdSotarchMergeToSelect(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SotarchInfo> buildVisitorHook(DeciTreeOption<SotarchInfo> option) {
		return new VisiSotarchMergeToSelect(option);
	}
}
