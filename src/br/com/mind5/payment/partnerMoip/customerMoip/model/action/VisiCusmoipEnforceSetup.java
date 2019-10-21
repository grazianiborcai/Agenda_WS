package br.com.mind5.payment.partnerMoip.customerMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipSetterSetup;

final class VisiCusmoipEnforceSetup extends ActionVisitorTemplateEnforce<CusmoipInfo> {
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterSetup();
		return setter.setAttr(recordInfo);
	}
}
