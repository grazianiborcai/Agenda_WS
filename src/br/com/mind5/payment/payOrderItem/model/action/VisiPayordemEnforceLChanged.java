package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemSetterLChanged;

final class VisiPayordemEnforceLChanged extends ActionVisitorTemplateEnforceV2<PayordemInfo> {
	
	public VisiPayordemEnforceLChanged(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> attrSetter = new PayordemSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
