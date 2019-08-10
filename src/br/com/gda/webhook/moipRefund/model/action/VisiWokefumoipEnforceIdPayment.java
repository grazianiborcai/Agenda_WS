package br.com.gda.webhook.moipRefund.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;
import br.com.gda.webhook.moipRefund.info.WokefumoipSetterIdPayment;

final class VisiWokefumoipEnforceIdPayment extends ActionVisitorTemplateEnforce<WokefumoipInfo> {
	
	@Override protected WokefumoipInfo enforceHook(WokefumoipInfo recordInfo) {
		InfoSetter<WokefumoipInfo> attrSetter = new WokefumoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
