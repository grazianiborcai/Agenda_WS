package br.com.mind5.business.storeSnapshot.model.action;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapEnforceStorextsnapKey extends ActionStdTemplateV2<StorapInfo> {

	public StdStorapEnforceStorextsnapKey(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorapInfo> buildVisitorHook(DeciTreeOption<StorapInfo> option) {
		return new VisiStorapEnforceStorextsnapKey(option);
	}
}
