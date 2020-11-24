package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipSuccess extends ActionStdSuccessTemplate<PeresmoipInfo> {
	
	public StdPeresmoipSuccess(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
}
