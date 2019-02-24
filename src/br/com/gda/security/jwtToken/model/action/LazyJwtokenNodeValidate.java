package br.com.gda.security.jwtToken.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.decisionTree.NodeJwtokenValidate;

public final class LazyJwtokenNodeValidate extends ActionLazyTemplate<JwtokenInfo, JwtokenInfo> {
	
	public LazyJwtokenNodeValidate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<JwtokenInfo> translateRecordInfosHook(List<JwtokenInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<JwtokenInfo> getInstanceOfActionHook(DeciTreeOption<JwtokenInfo> option) {
		return new NodeJwtokenValidate(option).toAction();
	}
	
	
	
	@Override protected DeciResult<JwtokenInfo> translateResultHook(DeciResult<JwtokenInfo> result) {
		return result;
	}
}
