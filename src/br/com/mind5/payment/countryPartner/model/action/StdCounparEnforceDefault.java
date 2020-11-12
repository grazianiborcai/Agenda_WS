package br.com.mind5.payment.countryPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class StdCounparEnforceDefault extends ActionStdTemplateV2<CounparInfo> {

	public StdCounparEnforceDefault(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CounparInfo> buildVisitorHook(DeciTreeOption<CounparInfo> option) {
		return new VisiCounparEnforceDefault(option);
	}
}
