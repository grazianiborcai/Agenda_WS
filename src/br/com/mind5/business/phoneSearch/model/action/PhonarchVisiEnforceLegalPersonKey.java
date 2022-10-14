package br.com.mind5.business.phoneSearch.model.action;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchSetterLegalPersonKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonarchVisiEnforceLegalPersonKey extends ActionVisitorTemplateEnforce<PhonarchInfo> {
	
	public PhonarchVisiEnforceLegalPersonKey(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	
	@Override protected PhonarchInfo enforceHook(PhonarchInfo recordInfo) {
		InfoSetter<PhonarchInfo> attrSetter = new PhonarchSetterLegalPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
