package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiStoreEnforceCreatedBy extends ActionVisitorTemplateEnforce<StoreInfo> {
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
