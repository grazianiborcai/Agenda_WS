package br.com.mind5.security.otpUserPassword.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class StdOtperasDaoInsert extends ActionStdTemplateV2<OtperasInfo> {

	public StdOtperasDaoInsert(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OtperasInfo> buildVisitorHook(DeciTreeOption<OtperasInfo> option) {
		return new VisiOtperasDaoInsert(option);
	}
}
