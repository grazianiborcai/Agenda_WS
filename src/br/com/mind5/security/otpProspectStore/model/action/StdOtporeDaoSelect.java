package br.com.mind5.security.otpProspectStore.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class StdOtporeDaoSelect extends ActionStdTemplateV2<OtporeInfo> {

	public StdOtporeDaoSelect(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OtporeInfo> buildVisitorHook(DeciTreeOption<OtporeInfo> option) {
		return new VisiOtporeDaoSelect(option);
	}
}
