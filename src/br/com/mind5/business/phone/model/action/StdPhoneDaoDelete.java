package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhoneDaoDelete extends ActionStdTemplate<PhoneInfo> {

	public StdPhoneDaoDelete(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhoneInfo> buildVisitorHook(DeciTreeOption<PhoneInfo> option) {
		return new VisiPhoneDaoDelete(option);
	}
}
