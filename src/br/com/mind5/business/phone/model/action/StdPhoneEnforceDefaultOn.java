package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhoneEnforceDefaultOn extends ActionStdTemplate<PhoneInfo> {

	public StdPhoneEnforceDefaultOn(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhoneInfo> buildVisitorHook(DeciTreeOption<PhoneInfo> option) {
		return new VisiPhoneEnforceDefaultOn(option);
	}
}
