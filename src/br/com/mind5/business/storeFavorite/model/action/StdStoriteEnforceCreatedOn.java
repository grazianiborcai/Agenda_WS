package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoriteEnforceCreatedOn extends ActionStdTemplate<StoriteInfo> {

	public StdStoriteEnforceCreatedOn(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoriteInfo> buildVisitorHook(DeciTreeOption<StoriteInfo> option) {
		return new VisiStoriteEnforceCreatedOn(option);
	}
}
