package br.com.mind5.business.phoneSearch.model.action;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonarchVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<PhonarchInfo> {
	
	public PhonarchVisiEnforceStoreKey(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PhonarchInfo enforceHook(PhonarchInfo recordInfo) {
		InfoSetter<PhonarchInfo> attrSetter = new PhonarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
