package br.com.gda.payment.customerMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;
import br.com.gda.payment.customerMoip.info.CusmoipSetterDocument;

final class VisiCusmoipEnforceDocument extends ActionVisitorTemplateEnforce<CusmoipInfo> {
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterDocument();
		return setter.setAttr(recordInfo);
	}
}
