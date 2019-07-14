package br.com.gda.payment.partnerMoip.customerMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipSetterRequest;

final class VisiCusmoipEnforceRequest extends ActionVisitorTemplateEnforce<CusmoipInfo> {
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterRequest();
		return setter.setAttr(recordInfo);
	}
}
