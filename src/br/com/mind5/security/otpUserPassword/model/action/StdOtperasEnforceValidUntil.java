package br.com.mind5.security.otpUserPassword.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class StdOtperasEnforceValidUntil extends ActionStdTemplate<OtperasInfo> {

	public StdOtperasEnforceValidUntil(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OtperasInfo> buildVisitorHook(DeciTreeOption<OtperasInfo> option) {
		return new VisiOtperasEnforceValidUntil(option);
	}
}
