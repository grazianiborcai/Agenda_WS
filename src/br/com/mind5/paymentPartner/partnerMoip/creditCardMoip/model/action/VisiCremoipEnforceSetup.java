package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipSetterSetup;

final class VisiCremoipEnforceSetup extends ActionVisitorTemplateEnforce<CremoipInfo> {
	
	public VisiCremoipEnforceSetup(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterSetup();
		return setter.setAttr(recordInfo);
	}
}
