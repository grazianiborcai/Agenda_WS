package br.com.mind5.security.jwtToken.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.NodeJwtokenValidateL1;

public final class LazyJwtokenNodeValidateL1 extends ActionLazyTemplate<JwtokenInfo, JwtokenInfo> {
	
	public LazyJwtokenNodeValidateL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<JwtokenInfo> translateRecordInfosHook(List<JwtokenInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<JwtokenInfo> getInstanceOfActionHook(DeciTreeOption<JwtokenInfo> option) {
		return new NodeJwtokenValidateL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<JwtokenInfo> translateResultHook(DeciResult<JwtokenInfo> result) {
		return result;
	}
}
