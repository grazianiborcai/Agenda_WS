package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorbyEnforceHash02Key extends ActionStdTemplate<StorbyInfo> {

	public StdStorbyEnforceHash02Key(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorbyInfo> buildVisitorHook(DeciTreeOption<StorbyInfo> option) {
		return new VisiStorbyEnforceHash02Key(option);
	}
}
