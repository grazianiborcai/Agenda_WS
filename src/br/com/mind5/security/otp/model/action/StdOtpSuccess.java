package br.com.mind5.security.otp.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;

public final class StdOtpSuccess extends ActionStdSuccessTemplate<OtpInfo> {
	
	public StdOtpSuccess(DeciTreeOption<OtpInfo> option) {
		super(OtpInfo.class);
	}
}
