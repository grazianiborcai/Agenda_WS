package br.com.gda.security.user.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.action.LazyUserSelect;
import br.com.gda.security.user.model.action.StdUserEnforceKey;

public final class UserCheckExist extends ModelCheckerTemplateAction<UserInfo> {
	
	public UserCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	//TODO: adicionar checkArgument para verificar campos de busca estao preenchidos
	
	@Override protected ActionStd<UserInfo> buildActionHook(UserInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UserInfo> actionSelect = new StdUserEnforceKey(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.USER_ALREADY_EXIST)
			return SystemMessage.USER_ALREADY_EXIST;
		
		return SystemMessage.USER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.USER_ALREADY_EXIST;	
			
		return SystemCode.USER_NOT_FOUND;
	}
}
