package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipEnforceExpected extends ActionStdTemplate<PeresmoipInfo> {

	public StdPeresmoipEnforceExpected(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PeresmoipInfo> buildVisitorHook(DeciTreeOption<PeresmoipInfo> option) {
		return new VisiPeresmoipEnforceExpected(option);
	}
}
