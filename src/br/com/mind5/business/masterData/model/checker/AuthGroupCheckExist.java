package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.business.masterData.model.action.StdAuthGroupSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AuthGroupCheckExist extends ModelCheckerTemplateAction_<AuthGroupInfo> {
	
	public AuthGroupCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<AuthGroupInfo> buildActionHook(AuthGroupInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AuthGroupInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<AuthGroupInfo> actionSelect = new StdAuthGroupSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<AuthGroupInfo> buildActionOption(AuthGroupInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AuthGroupInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.AUTH_GROUP_ALREADY_EXIST)
			return SystemMessage.AUTH_GROUP_ALREADY_EXIST;
		
		return SystemMessage.AUTH_GROUP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.AUTH_GROUP_ALREADY_EXIST;	
			
		return SystemCode.AUTH_GROUP_NOT_FOUND;
	}
}
