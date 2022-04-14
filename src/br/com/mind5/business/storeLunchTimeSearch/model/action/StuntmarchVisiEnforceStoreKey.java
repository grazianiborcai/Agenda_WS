package br.com.mind5.business.storeLunchTimeSearch.model.action;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmarchVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<StuntmarchInfo> {
	
	public StuntmarchVisiEnforceStoreKey(DeciTreeOption<StuntmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StuntmarchInfo enforceHook(StuntmarchInfo recordInfo) {
		InfoSetter<StuntmarchInfo> attrSetter = new StuntmarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
