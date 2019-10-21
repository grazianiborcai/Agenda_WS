package br.com.mind5.payment.payOrderSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.info.PayordarchSetterOrderKey;

final class VisiPayordarchEnforceOrderKey extends ActionVisitorTemplateEnforce<PayordarchInfo> {
	
	@Override protected PayordarchInfo enforceHook(PayordarchInfo recordInfo) {
		InfoSetter<PayordarchInfo> attrSetter = new PayordarchSetterOrderKey();
		return attrSetter.setAttr(recordInfo);
	}
}
