package br.com.mind5.business.storeProspect.model.action;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoprosEnforceCreated extends ActionStdTemplateV2<StoprosInfo> {

	public StdStoprosEnforceCreated(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoprosInfo> buildVisitorHook(DeciTreeOption<StoprosInfo> option) {
		return new VisiStoprosEnforceCreated(option);
	}
}
