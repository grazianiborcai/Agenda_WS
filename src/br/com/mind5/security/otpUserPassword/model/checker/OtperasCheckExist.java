package br.com.mind5.security.otpUserPassword.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasDaoSelect;

public final class OtperasCheckExist extends ModelCheckerTemplateAction<OtperasInfo, OtperasInfo> {
	
	public OtperasCheckExist(ModelCheckerOption option) {
		super(option, OtperasInfo.class);
	}
	
	
	
	@Override protected ActionStd<OtperasInfo> buildActionHook(DeciTreeOption<OtperasInfo> option) {
		ActionStd<OtperasInfo> select = new StdOtperasDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.OTP_USER_PASSWORD_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_USER_PASSWORD_NOT_FOUND;
	}
}
