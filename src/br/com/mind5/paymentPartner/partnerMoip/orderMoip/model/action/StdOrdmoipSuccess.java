package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class StdOrdmoipSuccess extends ActionStdSuccessTemplate<OrdmoipInfo> {

	public StdOrdmoipSuccess(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
}
