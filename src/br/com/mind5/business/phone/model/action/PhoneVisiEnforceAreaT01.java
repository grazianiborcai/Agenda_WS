package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterAreaT01;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiEnforceAreaT01 extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	public PhoneVisiEnforceAreaT01(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> setterAttr = new PhoneSetterAreaT01();
		return setterAttr.setAttr(recordInfo);
	}
}
