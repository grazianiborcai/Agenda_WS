package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiStolateEnforceCreatedOn extends ActionVisitorTemplateEnforce<StolateInfo> {
	
	@Override protected StolateInfo enforceHook(StolateInfo recordInfo) {
		InfoSetter<StolateInfo> attrSetter = new StolateSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
