package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoriteMergeToSelect extends ActionStdTemplate<StoriteInfo> {

	public StdStoriteMergeToSelect(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoriteInfo> buildVisitorHook(DeciTreeOption<StoriteInfo> option) {
		return new VisiStoriteMergeToSelect(option);
	}
}
