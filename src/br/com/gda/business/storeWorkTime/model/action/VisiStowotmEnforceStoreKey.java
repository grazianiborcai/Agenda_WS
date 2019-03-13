package br.com.gda.business.storeWorkTime.model.action;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.info.StowotmSetterStoreKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStowotmEnforceStoreKey extends ActionVisitorTemplateEnforce<StowotmInfo> {
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
