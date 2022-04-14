package br.com.mind5.business.storeLunchTime.model.action;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<StuntmInfo> {
	
	public StuntmVisiEnforceStoreKey(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StuntmInfo enforceHook(StuntmInfo recordInfo) {
		InfoSetter<StuntmInfo> attrSetter = new StuntmSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
