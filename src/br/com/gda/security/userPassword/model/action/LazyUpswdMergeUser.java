package br.com.gda.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class LazyUpswdMergeUser extends ActionLazyTemplate<UpswdInfo, UpswdInfo> {
	
	public LazyUpswdMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UpswdInfo> translateRecordInfosHook(List<UpswdInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getInstanceOfActionHook(DeciTreeOption<UpswdInfo> option) {
		return new StdUpswdMergeUser(option);
	}
	
	
	
	@Override protected DeciResult<UpswdInfo> translateResultHook(DeciResult<UpswdInfo> result) {
		return result;
	}
}
