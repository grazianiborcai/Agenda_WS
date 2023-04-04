package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemSetterPayordKey;

public final class PayordemVisiEnforcePayordKey extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	public PayordemVisiEnforcePayordKey(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> attrSetter = new PayordemSetterPayordKey();
		return attrSetter.setAttr(recordInfo);
	}
}
