package br.com.mind5.payment.payOrderItemSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchSetterReverted;

public final class PayormarchVisiEnforceReverted extends ActionVisitorTemplateEnforce<PayormarchInfo> {
	
	public PayormarchVisiEnforceReverted(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayormarchInfo enforceHook(PayormarchInfo recordInfo) {
		InfoSetter<PayormarchInfo> attrSetter = new PayormarchSetterReverted();
		return attrSetter.setAttr(recordInfo);
	}
}
