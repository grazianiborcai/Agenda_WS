package br.com.gda.payment.payOrderMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrderMoip.info.PayordmoipInfo;
import br.com.gda.payment.payOrderMoip.info.PayordmoipSetterAmount;

final class VisiPayordmoipEnforceAmount extends ActionVisitorTemplateEnforce<PayordmoipInfo> {
	
	@Override protected PayordmoipInfo enforceHook(PayordmoipInfo recordInfo) {
		InfoSetter<PayordmoipInfo> setter = new PayordmoipSetterAmount();
		return setter.setAttr(recordInfo);
	}
}
