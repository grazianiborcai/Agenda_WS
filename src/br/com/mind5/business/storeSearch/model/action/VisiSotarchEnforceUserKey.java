package br.com.mind5.business.storeSearch.model.action;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.info.SotarchSetterUserKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSotarchEnforceUserKey extends ActionVisitorTemplateEnforce<SotarchInfo> {
	
	public VisiSotarchEnforceUserKey(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SotarchInfo enforceHook(SotarchInfo recordInfo) {
		InfoSetter<SotarchInfo> attrSetter = new SotarchSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
