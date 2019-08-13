package br.com.gda.business.storeSnapshot.model.action;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.info.StoreSetterPersonKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStoreEnforcePersonKey extends ActionVisitorTemplateEnforce<StorapInfo> {
	
	@Override protected StorapInfo enforceHook(StorapInfo recordInfo) {
		InfoSetter<StorapInfo> attrSetter = new StoreSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
