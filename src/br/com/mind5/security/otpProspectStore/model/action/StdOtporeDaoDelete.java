package br.com.mind5.security.otpProspectStore.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class StdOtporeDaoDelete extends ActionStdTemplate<OtporeInfo> {

	public StdOtporeDaoDelete(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OtporeInfo> buildVisitorHook(DeciTreeOption<OtporeInfo> option) {
		return new VisiOtporeDaoDelete(option);
	}
}
