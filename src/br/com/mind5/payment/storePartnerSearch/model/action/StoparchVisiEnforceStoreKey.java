package br.com.mind5.payment.storePartnerSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchSetterStoreKey;

public final class StoparchVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<StoparchInfo> {
	
	public StoparchVisiEnforceStoreKey(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoparchInfo enforceHook(StoparchInfo recordInfo) {
		InfoSetter<StoparchInfo> attrSetter = new StoparchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
