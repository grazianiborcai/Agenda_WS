package br.com.mind5.business.storeProspect.model.action;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoprosMergeProstus extends ActionStdTemplate<StoprosInfo> {

	public StdStoprosMergeProstus(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoprosInfo> buildVisitorHook(DeciTreeOption<StoprosInfo> option) {
		return new VisiStoprosMergeProstus(option);
	}
}
