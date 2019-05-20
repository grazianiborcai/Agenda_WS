package br.com.gda.business.userSnapshot_.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.business.userSnapshot_.model.action.LazyUserSnapSelect;
import br.com.gda.business.userSnapshot_.model.action.StdUserSnapEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class UserSnapCheckExist extends ModelCheckerTemplateAction<UserSnapInfo> {
	
	public UserSnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<UserSnapInfo> buildActionHook(UserSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserSnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UserSnapInfo> actionSelect = new StdUserSnapEnforceKey(option);
		actionSelect.addPostAction(new LazyUserSnapSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<UserSnapInfo> buildActionOption(UserSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserSnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.USER_SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.USER_SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.USER_SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.USER_SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.USER_SNAPSHOT_NOT_FOUND;
	}
}
