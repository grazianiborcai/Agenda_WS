package br.com.mind5.business.storeProspectSearch.model.action;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoprarchMergeToSelect extends ActionStdTemplateV2<StoprarchInfo> {

	public StdStoprarchMergeToSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoprarchInfo> buildVisitorHook(DeciTreeOption<StoprarchInfo> option) {
		return new VisiStoprarchMergeToSelect(option);
	}
}
