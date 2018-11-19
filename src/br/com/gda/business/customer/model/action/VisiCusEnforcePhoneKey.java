package br.com.gda.business.customer.model.action;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusSetterPhoneKey;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCusEnforcePhoneKey extends ActionVisitorTemplateEnforce<CusInfo> {
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		CusSetterPhoneKey attrSetter = new CusSetterPhoneKey();
		return attrSetter.setAttr(recordInfo);
	}
}
