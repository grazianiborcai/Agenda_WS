package br.com.mind5.business.storeFavoriteSearch.model.action;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoritarchMergeToSelect extends ActionStdTemplateV2<StoritarchInfo> {

	public StdStoritarchMergeToSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoritarchInfo> buildVisitorHook(DeciTreeOption<StoritarchInfo> option) {
		return new VisiStoritarchMergeToSelect(option);
	}
}
