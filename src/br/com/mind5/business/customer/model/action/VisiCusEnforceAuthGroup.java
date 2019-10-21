package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterCodAuthGroup;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCusEnforceAuthGroup extends ActionVisitorTemplateEnforce<CusInfo> {
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterCodAuthGroup();
		return attrSetter.setAttr(recordInfo);
	}
}
