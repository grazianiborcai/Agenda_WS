package br.com.gda.payment.partnerMoip.customerMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipSetterDocument;

final class VisiCusmoipEnforceDocument extends ActionVisitorTemplateEnforce<CusmoipInfo> {
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterDocument();
		return setter.setAttr(recordInfo);
	}
}
