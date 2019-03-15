package br.com.gda.business.storeLeaveDate.model.action;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateSetterStoreKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStolevateEnforceStoreKey extends ActionVisitorTemplateEnforce<StolevateInfo> {
	
	@Override protected StolevateInfo enforceHook(StolevateInfo recordInfo) {
		InfoSetter<StolevateInfo> attrSetter = new StolevateSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
