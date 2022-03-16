package br.com.mind5.business.storeAccount.model.action;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.info.StoracSetterAccountCompleted;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoracVisiEnforceAccountCompleted extends ActionVisitorTemplateEnforce<StoracInfo> {
	
	public StoracVisiEnforceAccountCompleted(DeciTreeOption<StoracInfo> option) {
		super(option);
	}

	
	
	@Override protected StoracInfo enforceHook(StoracInfo recordInfo) {
		InfoSetter<StoracInfo> attrSetter = new StoracSetterAccountCompleted();
		return attrSetter.setAttr(recordInfo);
	}
}
