package br.com.gda.business.storeLeaveDate.model.action;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.info.StolateSetterStoreKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStolateEnforceStoreKey extends ActionVisitorTemplateEnforce<StolateInfo> {
	
	@Override protected StolateInfo enforceHook(StolateInfo recordInfo) {
		InfoSetter<StolateInfo> attrSetter = new StolateSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
