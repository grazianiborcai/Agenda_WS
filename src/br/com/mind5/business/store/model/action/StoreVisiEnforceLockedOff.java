package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreSetterLockedOff;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiEnforceLockedOff extends ActionVisitorTemplateEnforce<StoreInfo> {
	
	public StoreVisiEnforceLockedOff(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterLockedOff();
		return attrSetter.setAttr(recordInfo);
	}
}
