package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerEnforcePhoneKey extends ActionStdTemplate<OwnerInfo> {

	public StdOwnerEnforcePhoneKey(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnerInfo> buildVisitorHook(DeciTreeOption<OwnerInfo> option) {
		return new VisiOwnerEnforcePhoneKey(option);
	}
}
