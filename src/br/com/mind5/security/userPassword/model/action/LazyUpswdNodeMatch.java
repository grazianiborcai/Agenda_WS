package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.NodeUpswdMatch;

public final class LazyUpswdNodeMatch extends ActionLazyTemplate<UpswdInfo, UpswdInfo> {
	
	public LazyUpswdNodeMatch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UpswdInfo> translateRecordInfosHook(List<UpswdInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getInstanceOfActionHook(DeciTreeOption<UpswdInfo> option) {
		return new NodeUpswdMatch(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UpswdInfo> translateResultHook(DeciResult<UpswdInfo> result) {
		return result;
	}
}
