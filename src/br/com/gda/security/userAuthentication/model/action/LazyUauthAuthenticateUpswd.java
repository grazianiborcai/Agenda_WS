package br.com.gda.security.userAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userAuthentication.info.UauthInfo;

public final class LazyUauthAuthenticateUpswd extends ActionLazyTemplate<UauthInfo, UauthInfo> {
	
	public LazyUauthAuthenticateUpswd(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UauthInfo> translateRecordInfosHook(List<UauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UauthInfo> getInstanceOfActionHook(DeciTreeOption<UauthInfo> option) {
		return new StdUauthAuthenticateUpswd(option);
	}
	
	
	
	@Override protected DeciResult<UauthInfo> translateResultHook(DeciResult<UauthInfo> result) {
		return result;
	}
}
