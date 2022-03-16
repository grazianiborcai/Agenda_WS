package br.com.mind5.business.storeAccount.model.action;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.info.StoracSetterHasPartner;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoracVisiEnforceHasPartner extends ActionVisitorTemplateEnforce<StoracInfo> {
	
	public StoracVisiEnforceHasPartner(DeciTreeOption<StoracInfo> option) {
		super(option);
	}

	
	
	@Override protected StoracInfo enforceHook(StoracInfo recordInfo) {
		InfoSetter<StoracInfo> attrSetter = new StoracSetterHasPartner();
		return attrSetter.setAttr(recordInfo);
	}
}
