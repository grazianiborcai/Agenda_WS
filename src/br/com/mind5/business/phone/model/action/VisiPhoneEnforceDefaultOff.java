package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterDefaultOff;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhoneEnforceDefaultOff extends ActionVisitorTemplateEnforceV2<PhoneInfo> {
	
	public VisiPhoneEnforceDefaultOff(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> attrSetter = new PhoneSetterDefaultOff();
		return attrSetter.setAttr(recordInfo);
	}
}