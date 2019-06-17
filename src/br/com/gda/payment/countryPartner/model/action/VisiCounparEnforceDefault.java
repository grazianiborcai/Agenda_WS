package br.com.gda.payment.countryPartner.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.info.CounparSetterDefault;

final class VisiCounparEnforceDefault extends ActionVisitorTemplateEnforce<CounparInfo> {
	
	@Override protected CounparInfo enforceHook(CounparInfo recordInfo) {
		InfoSetter<CounparInfo> setter = new CounparSetterDefault();
		return setter.setAttr(recordInfo);
	}
}
