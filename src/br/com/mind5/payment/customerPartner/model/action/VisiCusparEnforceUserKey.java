package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparSetterUserKey;

final class VisiCusparEnforceUserKey extends ActionVisitorTemplateEnforce<CusparInfo> {
	
	@Override protected CusparInfo enforceHook(CusparInfo recordInfo) {
		InfoSetter<CusparInfo> setter = new CusparSetterUserKey();
		return setter.setAttr(recordInfo);
	}
}
