package br.com.gda.business.storeWorkTime.model.action;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.info.StowotmSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStowotmEnforceLChanged extends ActionVisitorTemplateEnforce<StowotmInfo> {
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
