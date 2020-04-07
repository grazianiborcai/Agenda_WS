package br.com.mind5.security.userPassword.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.StdUpswdSelect;

public final class UpswdCheckExist extends ModelCheckerTemplateActionV2<UpswdInfo, UpswdInfo> {
	
	public UpswdCheckExist(ModelCheckerOption option) {
		super(option, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<UpswdInfo> buildActionHook(DeciTreeOption<UpswdInfo> option) {
		ActionStdV1<UpswdInfo> select = new StdUpswdSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PASSWORD_AND_USERNAME_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
