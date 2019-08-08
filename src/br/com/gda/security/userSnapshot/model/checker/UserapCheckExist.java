package br.com.gda.security.userSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userSnapshot.info.UserapInfo;
import br.com.gda.security.userSnapshot.model.action.LazyUserapSelect;
import br.com.gda.security.userSnapshot.model.action.StdUserapEnforceKey;

public final class UserapCheckExist extends ModelCheckerTemplateAction<UserapInfo> {
	
	public UserapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<UserapInfo> buildActionHook(UserapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UserapInfo> actionSelect = new StdUserapEnforceKey(option);
		actionSelect.addPostAction(new LazyUserapSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<UserapInfo> buildActionOption(UserapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserapInfo> option = new DeciTreeOption<>();
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
