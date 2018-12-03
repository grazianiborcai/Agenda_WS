package br.com.gda.business.customer.model.action;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCusEnforceLChanged extends ActionVisitorTemplateEnforce<CusInfo> {
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
