package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.UserCategInfo;
import br.com.gda.business.masterData.model.action.StdUserCategSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class UserCategCheckExist extends ModelCheckerTemplateAction<UserCategInfo> {
	
	public UserCategCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<UserCategInfo> buildActionHook(UserCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserCategInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<UserCategInfo> actionSelect = new StdUserCategSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<UserCategInfo> buildActionOption(UserCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UserCategInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.USER_CATEG_ALREADY_EXIST)
			return SystemMessage.USER_CATEG_ALREADY_EXIST;
		
		return SystemMessage.USER_CATEG_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.USER_CATEG_ALREADY_EXIST;	
			
		return SystemCode.USER_CATEG_NOT_FOUND;
	}
}
