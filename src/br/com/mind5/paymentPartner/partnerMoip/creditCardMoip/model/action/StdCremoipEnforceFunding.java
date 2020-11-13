package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class StdCremoipEnforceFunding extends ActionStdTemplate<CremoipInfo> {

	public StdCremoipEnforceFunding(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CremoipInfo> buildVisitorHook(DeciTreeOption<CremoipInfo> option) {
		return new VisiCremoipEnforceFunding(option);
	}
}
