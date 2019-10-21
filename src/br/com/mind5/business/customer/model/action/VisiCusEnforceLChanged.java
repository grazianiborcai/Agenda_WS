package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCusEnforceLChanged extends ActionVisitorTemplateEnforce<CusInfo> {
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
