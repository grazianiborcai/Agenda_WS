package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterNumberT00;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiEnforceNumberT00 extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	public PhoneVisiEnforceNumberT00(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		PhoneInfo phone = recordInfo;		
		InfoSetter<PhoneInfo> setterAttr = new PhoneSetterNumberT00();
		return setterAttr.setAttr(phone);
	}
}
