package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.info.WokefumoipSetterIdPayment;

public final class WokefumoipVisiEnforceIdPayment extends ActionVisitorTemplateEnforce<WokefumoipInfo> {
	
	public WokefumoipVisiEnforceIdPayment(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected WokefumoipInfo enforceHook(WokefumoipInfo recordInfo) {
		InfoSetter<WokefumoipInfo> attrSetter = new WokefumoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
