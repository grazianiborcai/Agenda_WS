package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipSetterAddress;

public final class CremoipVisiEnforceAddress extends ActionVisitorTemplateEnforce<CremoipInfo> {
	
	public CremoipVisiEnforceAddress(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterAddress();
		return setter.setAttr(recordInfo);
	}
}
