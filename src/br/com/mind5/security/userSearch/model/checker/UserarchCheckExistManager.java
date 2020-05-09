package br.com.mind5.security.userSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.LazyUserarchRootSelect;
import br.com.mind5.security.userSearch.model.action.StdUserarchEnforceManager;

public final class UserarchCheckExistManager extends ModelCheckerTemplateActionV2<UserarchInfo, UserarchInfo> {
	
	public UserarchCheckExistManager(ModelCheckerOption option) {
		super(option, UserarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<UserarchInfo> buildActionHook(DeciTreeOption<UserarchInfo> option) {
		ActionStdV1<UserarchInfo> enforceManager = new StdUserarchEnforceManager(option);
		ActionLazyV1<UserarchInfo> select = new LazyUserarchRootSelect(option.conn, option.schemaName);
		
		enforceManager.addPostAction(select);
		return enforceManager;
	}
	
	

	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SEARCH_NOT_FOUND;
	}
}
