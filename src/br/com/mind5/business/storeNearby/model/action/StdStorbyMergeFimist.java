package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorbyMergeFimist extends ActionStdTemplate<StorbyInfo> {

	public StdStorbyMergeFimist(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorbyInfo> buildVisitorHook(DeciTreeOption<StorbyInfo> option) {
		return new VisiStorbyMergeFimist(option);
	}
}
