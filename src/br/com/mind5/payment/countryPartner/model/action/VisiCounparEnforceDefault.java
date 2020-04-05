package br.com.mind5.payment.countryPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.info.CounparSetterDefault;

final class VisiCounparEnforceDefault extends ActionVisitorTemplateEnforceV1<CounparInfo> {
	
	@Override protected CounparInfo enforceHook(CounparInfo recordInfo) {
		InfoSetter<CounparInfo> setter = new CounparSetterDefault();
		return setter.setAttr(recordInfo);
	}
}
