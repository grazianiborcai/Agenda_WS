package br.com.mind5.security.otp.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;

public final class StdOtpEnforceRandom extends ActionStdTemplateV2<OtpInfo> {

	public StdOtpEnforceRandom(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OtpInfo> buildVisitorHook(DeciTreeOption<OtpInfo> option) {
		return new VisiOtpEnforceRandom(option);
	}
}
