package br.com.gda.business.user.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserSelect;
import br.com.gda.business.user.model.action.StdUserEnforcePersonChange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class UserCheckPersonChange extends ModelCheckerTemplateAction<UserInfo> {
	
	public UserCheckPersonChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<UserInfo> buildActionHook(UserInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UserInfo> actionSelect = new StdUserEnforcePersonChange(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.USER_PERSON_NOT_CHANGED)
			return SystemMessage.USER_PERSON_NOT_CHANGED;
		
		return SystemMessage.USER_PERSON_CANT_BE_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.USER_PERSON_NOT_CHANGED;	
			
		return SystemCode.USER_PERSON_CANT_BE_CHANGED;
	}
}
