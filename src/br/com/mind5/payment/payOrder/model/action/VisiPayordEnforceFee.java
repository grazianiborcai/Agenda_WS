package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordSetterFee;

final class VisiPayordEnforceFee extends ActionVisitorTemplateEnforceV2<PayordInfo> {
	
	public VisiPayordEnforceFee(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayordInfo enforceHook(PayordInfo recordInfo) {
		InfoSetter<PayordInfo> attrSetter = new PayordSetterFee();
		return attrSetter.setAttr(recordInfo);
	}
}
