package br.com.gda.security.storeAuthorization.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.decisionTree.RootStorauthSelect;

public final class StorauthCheckExist extends ModelCheckerTemplateAction_<StorauthInfo> {
	
	public StorauthCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StorauthInfo> buildActionHook(StorauthInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StorauthInfo> option = buildOption(recordInfo, conn, schemaName);
		
		return new RootStorauthSelect(option).toAction();
	}
	
	
	
	private DeciTreeOption<StorauthInfo> buildOption(StorauthInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StorauthInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {			
		return SystemMessage.STORE_AUTH_NOT_AUTHORIZED ;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.STORE_AUTH_NOT_AUTHORIZED ;
	}
}
