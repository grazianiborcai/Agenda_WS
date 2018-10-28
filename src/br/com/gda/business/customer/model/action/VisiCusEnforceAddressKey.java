package br.com.gda.business.customer.model.action;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusSetterAddressKey;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCusEnforceAddressKey extends ActionVisitorTemplateEnforce<CusInfo> {
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		CusSetterAddressKey attrSetter = new CusSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
