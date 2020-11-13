package br.com.mind5.security.userPassword.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.StdUpswdDaoSelect;

public final class UpswdCheckExist extends ModelCheckerTemplateActionV2<UpswdInfo, UpswdInfo> {
	
	public UpswdCheckExist(ModelCheckerOption option) {
		super(option, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<UpswdInfo> buildActionHook(DeciTreeOption<UpswdInfo> option) {
		ActionStdV2<UpswdInfo> select = new StdUpswdDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PASSWORD_AND_USERNAME_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
