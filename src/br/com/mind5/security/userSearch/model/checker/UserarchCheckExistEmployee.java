package br.com.mind5.security.userSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.UserarchRootSelectEmployee;

public final class UserarchCheckExistEmployee extends ModelCheckerTemplateAction<UserarchInfo, UserarchInfo> {
	
	public UserarchCheckExistEmployee(ModelCheckerOption option) {
		super(option, UserarchInfo.class);
	}
	

	
	@Override protected ActionStd<UserarchInfo> buildActionHook(DeciTreeOption<UserarchInfo> option) {
		ActionStd<UserarchInfo> select = new UserarchRootSelectEmployee(option).toAction();
		return select;
	}
	
	

	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SEARCH_NOT_FOUND;
	}
}
