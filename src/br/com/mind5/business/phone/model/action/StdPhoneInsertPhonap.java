package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhoneInsertPhonap extends ActionStdTemplateV2<PhoneInfo> {

	public StdPhoneInsertPhonap(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PhoneInfo> buildVisitorHook(DeciTreeOption<PhoneInfo> option) {
		return new VisiPhoneInsertPhonap(option);
	}
}
