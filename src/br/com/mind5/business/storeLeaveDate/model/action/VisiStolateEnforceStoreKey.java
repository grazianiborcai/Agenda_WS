package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiStolateEnforceStoreKey extends ActionVisitorTemplateEnforce<StolateInfo> {
	
	@Override protected StolateInfo enforceHook(StolateInfo recordInfo) {
		InfoSetter<StolateInfo> attrSetter = new StolateSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
