package br.com.mind5.security.userSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.RootUserarchSelectEmployee;

public final class UserarchCheckExistEmployee extends ModelCheckerTemplateActionV2<UserarchInfo, UserarchInfo> {
	
	public UserarchCheckExistEmployee(ModelCheckerOption option) {
		super(option, UserarchInfo.class);
	}
	

	
	@Override protected ActionStdV2<UserarchInfo> buildActionHook(DeciTreeOption<UserarchInfo> option) {
		ActionStdV2<UserarchInfo> select = new RootUserarchSelectEmployee(option).toAction();
		return select;
	}
	
	

	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SEARCH_NOT_FOUND;
	}
}
