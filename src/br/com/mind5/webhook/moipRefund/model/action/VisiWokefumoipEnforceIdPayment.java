package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.info.WokefumoipSetterIdPayment;

final class VisiWokefumoipEnforceIdPayment extends ActionVisitorTemplateEnforceV2<WokefumoipInfo> {
	
	public VisiWokefumoipEnforceIdPayment(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected WokefumoipInfo enforceHook(WokefumoipInfo recordInfo) {
		InfoSetter<WokefumoipInfo> attrSetter = new WokefumoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
