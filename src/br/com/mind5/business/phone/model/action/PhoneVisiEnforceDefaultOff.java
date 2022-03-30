package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterDefaultOff;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiEnforceDefaultOff extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	public PhoneVisiEnforceDefaultOff(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> attrSetter = new PhoneSetterDefaultOff();
		return attrSetter.setAttr(recordInfo);
	}
}
