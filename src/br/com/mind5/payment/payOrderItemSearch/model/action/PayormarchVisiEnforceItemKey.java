package br.com.mind5.payment.payOrderItemSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchSetterItemKey;

public final class PayormarchVisiEnforceItemKey extends ActionVisitorTemplateEnforce<PayormarchInfo> {
	
	public PayormarchVisiEnforceItemKey(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayormarchInfo enforceHook(PayormarchInfo recordInfo) {
		InfoSetter<PayormarchInfo> attrSetter = new PayormarchSetterItemKey();
		return attrSetter.setAttr(recordInfo);
	}
}
