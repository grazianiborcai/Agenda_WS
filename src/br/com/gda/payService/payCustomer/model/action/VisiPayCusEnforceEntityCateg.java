package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusSetterCodEntityCateg;

final class VisiPayCusEnforceEntityCateg extends ActionVisitorTemplateEnforce<PayCusInfo> {
	
	@Override protected PayCusInfo enforceHook(PayCusInfo recordInfo) {
		InfoSetter<PayCusInfo> attrSetter = new PayCusSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
