package br.com.mind5.business.storeCatalogue.model.action;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStogueMergeStorby extends ActionStdTemplateV2<StogueInfo> {
	
	public StdStogueMergeStorby(DeciTreeOption<StogueInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StogueInfo> buildVisitorHook(DeciTreeOption<StogueInfo> option) {
		return new VisiStogueMergeStorby(option);
	}
}
