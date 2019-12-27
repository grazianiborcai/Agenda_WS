package br.com.mind5.security.user.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserSelect;
import br.com.mind5.security.user.model.action.StdUserEnforceUsernameKey_;

public final class UserCheckUsernameExist extends ModelCheckerTemplateAction_<UserInfo> {
	
	public UserCheckUsernameExist(ModelCheckerOption option) {
		super(option);
	}
	
	//TODO: adicionar checkArgument para verificar campos de busca estao preenchidos
	
	@Override protected ActionStd<UserInfo> buildActionHook(UserInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UserInfo> actionSelect = new StdUserEnforceUsernameKey_(option);
		actionSelect.addPostAction(new LazyUserSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<UserInfo> buildActionOption(UserInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.USER_USERNAME_ALREADY_EXIST)
			return SystemMessage.USER_USERNAME_ALREADY_EXIST;
		
		return SystemMessage.USER_USERNAME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.USER_USERNAME_ALREADY_EXIST;	
			
		return SystemCode.USER_USERNAME_NOT_FOUND;
	}
}
