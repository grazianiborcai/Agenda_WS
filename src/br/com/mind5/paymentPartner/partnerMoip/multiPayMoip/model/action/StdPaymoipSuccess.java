package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipSuccess extends ActionStdSuccessTemplate<PaymoipInfo> {

	public StdPaymoipSuccess(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
}
