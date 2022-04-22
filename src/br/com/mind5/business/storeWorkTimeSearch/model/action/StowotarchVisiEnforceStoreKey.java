package br.com.mind5.business.storeWorkTimeSearch.model.action;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotarchVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<StowotarchInfo> {
	
	public StowotarchVisiEnforceStoreKey(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StowotarchInfo enforceHook(StowotarchInfo recordInfo) {
		InfoSetter<StowotarchInfo> attrSetter = new StowotarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
