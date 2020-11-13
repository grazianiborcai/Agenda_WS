package br.com.mind5.business.storeFavoriteSearch.model.action;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoritarchMergeToSelect extends ActionStdTemplate<StoritarchInfo> {

	public StdStoritarchMergeToSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoritarchInfo> buildVisitorHook(DeciTreeOption<StoritarchInfo> option) {
		return new VisiStoritarchMergeToSelect(option);
	}
}
