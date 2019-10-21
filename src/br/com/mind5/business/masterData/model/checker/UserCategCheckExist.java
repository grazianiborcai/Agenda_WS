package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.action.StdUserCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class UserCategCheckExist extends ModelCheckerTemplateAction_<UserCategInfo> {
	
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
