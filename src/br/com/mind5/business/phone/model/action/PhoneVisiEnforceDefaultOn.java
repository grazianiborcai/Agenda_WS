package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterDefaultOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiEnforceDefaultOn extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	public PhoneVisiEnforceDefaultOn(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> attrSetter = new PhoneSetterDefaultOn();
		return attrSetter.setAttr(recordInfo);
	}
}
