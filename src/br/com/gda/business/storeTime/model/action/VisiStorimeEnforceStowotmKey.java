package br.com.gda.business.storeTime.model.action;

import br.com.gda.business.storeTime.info.StorimeInfo;
import br.com.gda.business.storeTime.info.StorimeSetterStowotmKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStorimeEnforceStowotmKey extends ActionVisitorTemplateEnforce<StorimeInfo> {
	
	@Override protected StorimeInfo enforceHook(StorimeInfo recordInfo) {
		InfoSetter<StorimeInfo> attrSetter = new StorimeSetterStowotmKey();
		return attrSetter.setAttr(recordInfo);
	}
}
