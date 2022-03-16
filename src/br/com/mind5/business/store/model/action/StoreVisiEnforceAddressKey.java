package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreSetterAddressKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiEnforceAddressKey extends ActionVisitorTemplateEnforce<StoreInfo> {
	
	public StoreVisiEnforceAddressKey(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
