package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhoneDaoInsert extends ActionStdTemplateV2<PhoneInfo> {

	public StdPhoneDaoInsert(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PhoneInfo> buildVisitorHook(DeciTreeOption<PhoneInfo> option) {
		return new VisiPhoneDaoInsert(option);
	}
}