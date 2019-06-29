package br.com.gda.payment.customerPartner.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.info.CusparSetterUserKey;

final class VisiCusparEnforceUserKey extends ActionVisitorTemplateEnforce<CusparInfo> {
	
	@Override protected CusparInfo enforceHook(CusparInfo recordInfo) {
		InfoSetter<CusparInfo> setter = new CusparSetterUserKey();
		return setter.setAttr(recordInfo);
	}
}
