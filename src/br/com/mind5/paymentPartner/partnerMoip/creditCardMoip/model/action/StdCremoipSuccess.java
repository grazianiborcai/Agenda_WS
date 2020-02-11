package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class StdCremoipSuccess extends ActionStdSuccessTemplate<CremoipInfo> {
	public StdCremoipSuccess(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
}
