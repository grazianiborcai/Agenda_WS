package br.com.gda.payment.customerPartner.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.info.CusparSetterCompoundId;

final class VisiCusparEnforceCompoundId extends ActionVisitorTemplateEnforce<CusparInfo> {
	
	@Override protected CusparInfo enforceHook(CusparInfo recordInfo) {
		InfoSetter<CusparInfo> setter = new CusparSetterCompoundId();
		return setter.setAttr(recordInfo);
	}
}
