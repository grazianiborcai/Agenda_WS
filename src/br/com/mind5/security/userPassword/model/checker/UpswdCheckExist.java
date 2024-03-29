package br.com.mind5.security.userPassword.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.UpswdVisiDaoSelect;

public final class UpswdCheckExist extends ModelCheckerTemplateAction<UpswdInfo, UpswdInfo> {
	
	public UpswdCheckExist(ModelCheckerOption option) {
		super(option, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> buildActionHook(DeciTreeOption<UpswdInfo> option) {
		ActionStd<UpswdInfo> select = new ActionStdCommom<UpswdInfo>(option, UpswdVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PASSWORD_AND_USERNAME_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
