package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipEnforceExpected extends ActionStdTemplateV2<PeresmoipInfo> {

	public StdPeresmoipEnforceExpected(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PeresmoipInfo> buildVisitorHook(DeciTreeOption<PeresmoipInfo> option) {
		return new VisiPeresmoipEnforceExpected(option);
	}
}
