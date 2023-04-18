package br.com.mind5.payment.payOrderSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.info.PayordarchSetterWebhookKey;

public final class PayordarchVisiEnforceWebhookKey extends ActionVisitorTemplateEnforce<PayordarchInfo> {
	
	public PayordarchVisiEnforceWebhookKey(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayordarchInfo enforceHook(PayordarchInfo recordInfo) {
		InfoSetter<PayordarchInfo> attrSetter = new PayordarchSetterWebhookKey();
		return attrSetter.setAttr(recordInfo);
	}
}
