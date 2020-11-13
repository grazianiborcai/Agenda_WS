package br.com.mind5.business.storeCatalogue.model.action;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStogueMergeMatoup extends ActionStdTemplate<StogueInfo> {
	
	public StdStogueMergeMatoup(DeciTreeOption<StogueInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitor<StogueInfo> buildVisitorHook(DeciTreeOption<StogueInfo> option) {
		return new VisiStogueMergeMatoup(option);
	}
}
