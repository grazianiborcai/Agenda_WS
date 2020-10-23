package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmEnforceStoreKey extends ActionVisitorTemplateEnforceV2<StowotmInfo> {
	
	public VisiStowotmEnforceStoreKey(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
