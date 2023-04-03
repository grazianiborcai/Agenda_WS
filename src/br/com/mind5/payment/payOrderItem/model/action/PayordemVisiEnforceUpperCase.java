package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemSetterUpperCase;

public final class PayordemVisiEnforceUpperCase extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	public PayordemVisiEnforceUpperCase(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> attrSetter = new PayordemSetterUpperCase();
		return attrSetter.setAttr(recordInfo);
	}
}
