package br.com.mind5.security.otpUserPassword.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class StdOtperasSuccess extends ActionStdSuccessTemplate<OtperasInfo> {
	
	public StdOtperasSuccess(DeciTreeOption<OtperasInfo> option) {
		super(OtperasInfo.class);
	}
}
