package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipSetterIdPayment;

public final class WokaymoipVisiEnforceIdPayment extends ActionVisitorTemplateEnforce<WokaymoipInfo> {
	
	public WokaymoipVisiEnforceIdPayment(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected WokaymoipInfo enforceHook(WokaymoipInfo recordInfo) {
		InfoSetter<WokaymoipInfo> attrSetter = new WokaymoipSetterIdPayment();
		return attrSetter.setAttr(recordInfo);
	}
}
