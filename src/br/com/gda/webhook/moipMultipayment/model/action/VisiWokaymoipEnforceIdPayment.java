package br.com.gda.webhook.moipMultipayment.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipSetterIdPayment;

final class VisiWokaymoipEnforceIdPayment extends ActionVisitorTemplateEnforce<WokaymoipInfo> {
	
	@Override protected WokaymoipInfo enforceHook(WokaymoipInfo recordInfo) {
		InfoSetter<WokaymoipInfo> attrSetter = new WokaymoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
