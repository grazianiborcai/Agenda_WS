package br.com.mind5.security.jwtToken.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class LazyJwtokenEnforceSecret extends ActionLazyTemplateV2<JwtokenInfo, JwtokenInfo> {
	
	public LazyJwtokenEnforceSecret(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<JwtokenInfo> translateRecordInfosHook(List<JwtokenInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<JwtokenInfo> getInstanceOfActionHook(DeciTreeOption<JwtokenInfo> option) {
		return new StdJwtokenEnforceSecret(option);
	}
	
	
	
	@Override protected DeciResult<JwtokenInfo> translateResultHook(DeciResult<JwtokenInfo> result) {
		return result;
	}
}