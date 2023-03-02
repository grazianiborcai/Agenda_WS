package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordSetterObfuscate;

public final class PayordVisiObfuscate extends ActionVisitorTemplateEnforce<PayordInfo> {
	
	public PayordVisiObfuscate(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PayordInfo enforceHook(PayordInfo recordInfo) {
		InfoSetter<PayordInfo> attrSetter = new PayordSetterObfuscate();
		return attrSetter.setAttr(recordInfo);
	}
}
