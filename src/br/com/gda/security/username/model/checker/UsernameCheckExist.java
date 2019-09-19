package br.com.gda.security.username.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.action.StdUsernameSelect;

public final class UsernameCheckExist extends ModelCheckerTemplateAction_<UsernameInfo> {
	
	public UsernameCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<UsernameInfo> buildActionHook(UsernameInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UsernameInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UsernameInfo> actionSelect = new StdUsernameSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<UsernameInfo> buildActionOption(UsernameInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UsernameInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.USERNAME_ALREADY_EXIST)
			return SystemMessage.USERNAME_ALREADY_EXIST;
		
		return SystemMessage.USERNAME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.USERNAME_ALREADY_EXIST;	
			
		return SystemCode.USERNAME_NOT_FOUND;
	}
}
