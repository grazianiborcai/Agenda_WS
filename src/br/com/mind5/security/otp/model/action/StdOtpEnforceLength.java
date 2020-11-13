package br.com.mind5.security.otp.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;

public final class StdOtpEnforceLength extends ActionStdTemplate<OtpInfo> {

	public StdOtpEnforceLength(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OtpInfo> buildVisitorHook(DeciTreeOption<OtpInfo> option) {
		return new VisiOtpEnforceLength(option);
	}
}
