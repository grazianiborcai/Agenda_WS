package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorbyEnforceNameKey extends ActionStdTemplateV2<StorbyInfo> {

	public StdStorbyEnforceNameKey(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorbyInfo> buildVisitorHook(DeciTreeOption<StorbyInfo> option) {
		return new VisiStorbyEnforceNameKey(option);
	}
}
