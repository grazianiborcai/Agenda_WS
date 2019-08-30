package br.com.gda.payment.payOrderSearch.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;
import br.com.gda.payment.payOrderSearch.info.PayordarchSetterOrderKey;

final class VisiPayordarchEnforceOrderKey extends ActionVisitorTemplateEnforce<PayordarchInfo> {
	
	@Override protected PayordarchInfo enforceHook(PayordarchInfo recordInfo) {
		InfoSetter<PayordarchInfo> attrSetter = new PayordarchSetterOrderKey();
		return attrSetter.setAttr(recordInfo);
	}
}
