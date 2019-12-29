package br.com.mind5.security.user.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.StdUserSelect;

public final class UserCheckExist extends ModelCheckerTemplateActionV2<UserInfo, UserInfo> {
	
	public UserCheckExist(ModelCheckerOption option) {
		super(option, UserInfo.class);
	}
	

	
	@Override protected ActionStd<UserInfo> buildActionHook(DeciTreeOption<UserInfo> option) {
		ActionStd<UserInfo> select = new StdUserSelect(option);
		return select;
	}
	
	

	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_NOT_FOUND;
	}
}
