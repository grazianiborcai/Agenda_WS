package br.com.gda.payment.payOrder.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordSetterItemNum;

final class VisiPayordEnforceItemNum extends ActionVisitorTemplateEnforce<PayordInfo> {
	
	@Override protected PayordInfo enforceHook(PayordInfo recordInfo) {
		InfoSetter<PayordInfo> attrSetter = new PayordSetterItemNum();
		return attrSetter.setAttr(recordInfo);
	}
}
