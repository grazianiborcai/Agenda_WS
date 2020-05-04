package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipSetterIdPayment;

final class VisiWokaymoipEnforceIdPayment extends ActionVisitorTemplateEnforceV2<WokaymoipInfo> {
	
	public VisiWokaymoipEnforceIdPayment(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected WokaymoipInfo enforceHook(WokaymoipInfo recordInfo) {
		InfoSetter<WokaymoipInfo> attrSetter = new WokaymoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
