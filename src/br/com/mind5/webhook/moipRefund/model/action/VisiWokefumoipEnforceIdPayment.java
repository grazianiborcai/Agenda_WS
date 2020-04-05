package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.info.WokefumoipSetterIdPayment;

final class VisiWokefumoipEnforceIdPayment extends ActionVisitorTemplateEnforceV1<WokefumoipInfo> {
	
	@Override protected WokefumoipInfo enforceHook(WokefumoipInfo recordInfo) {
		InfoSetter<WokefumoipInfo> attrSetter = new WokefumoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
