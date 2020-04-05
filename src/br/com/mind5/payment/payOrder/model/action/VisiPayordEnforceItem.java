package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordSetterItem;

final class VisiPayordEnforceItem extends ActionVisitorTemplateEnforceV1<PayordInfo> {
	
	@Override protected PayordInfo enforceHook(PayordInfo recordInfo) {
		InfoSetter<PayordInfo> attrSetter = new PayordSetterItem();
		return attrSetter.setAttr(recordInfo);
	}
}
