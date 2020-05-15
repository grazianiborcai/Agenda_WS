package br.com.mind5.security.userSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.LazyUserarchRootSelectAuth;
import br.com.mind5.security.userSearch.model.action.StdUserarchEnforceOwner;

public final class UserarchCheckExistOwner extends ModelCheckerTemplateActionV2<UserarchInfo, UserarchInfo> {
	
	public UserarchCheckExistOwner(ModelCheckerOption option) {
		super(option, UserarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<UserarchInfo> buildActionHook(DeciTreeOption<UserarchInfo> option) {
		ActionStdV1<UserarchInfo> enforceOwner = new StdUserarchEnforceOwner(option);
		ActionLazyV1<UserarchInfo> select = new LazyUserarchRootSelectAuth(option.conn, option.schemaName);
		
		enforceOwner.addPostAction(select);
		return enforceOwner;
	}
	
	

	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SEARCH_NOT_FOUND;
	}
}
