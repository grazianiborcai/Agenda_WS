package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiStowotmEnforceDel extends ActionVisitorTemplateEnforce<StowotmInfo> {
	
	@Override protected StowotmInfo enforceHook(StowotmInfo recordInfo) {
		InfoSetter<StowotmInfo> attrSetter = new StowotmSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
