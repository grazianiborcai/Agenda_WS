package br.com.mind5.security.otpUserPassword.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasDaoSelect;

public final class OtperasCheckExist extends ModelCheckerTemplateActionV2<OtperasInfo, OtperasInfo> {
	
	public OtperasCheckExist(ModelCheckerOption option) {
		super(option, OtperasInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<OtperasInfo> buildActionHook(DeciTreeOption<OtperasInfo> option) {
		ActionStdV2<OtperasInfo> select = new StdOtperasDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.OTP_USER_PASSWORD_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_USER_PASSWORD_NOT_FOUND;
	}
}
