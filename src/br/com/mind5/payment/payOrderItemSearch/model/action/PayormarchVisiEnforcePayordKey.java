package br.com.mind5.payment.payOrderItemSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchSetterPayordKey;

public final class PayormarchVisiEnforcePayordKey extends ActionVisitorTemplateEnforce<PayormarchInfo> {
	
	public PayormarchVisiEnforcePayordKey(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayormarchInfo enforceHook(PayormarchInfo recordInfo) {
		InfoSetter<PayormarchInfo> attrSetter = new PayormarchSetterPayordKey();
		return attrSetter.setAttr(recordInfo);
	}
}
