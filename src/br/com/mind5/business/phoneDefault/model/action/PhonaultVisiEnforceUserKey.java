package br.com.mind5.business.phoneDefault.model.action;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.info.PhonaultSetterUserKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonaultVisiEnforceUserKey extends ActionVisitorTemplateEnforce<PhonaultInfo> {
	
	public PhonaultVisiEnforceUserKey(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}

	
	
	@Override protected PhonaultInfo enforceHook(PhonaultInfo recordInfo) {
		InfoSetter<PhonaultInfo> attrSetter = new PhonaultSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
