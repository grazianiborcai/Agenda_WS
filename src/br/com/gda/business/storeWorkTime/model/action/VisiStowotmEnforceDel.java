package br.com.gda.business.storeWorkTime.model.action;

import br.com.gda.business.storeWorkTime.info.StowotmSetterDel;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStowotmEnforceDel extends ActionVisitorTemplateEnforce<StowotmInfo> {
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
