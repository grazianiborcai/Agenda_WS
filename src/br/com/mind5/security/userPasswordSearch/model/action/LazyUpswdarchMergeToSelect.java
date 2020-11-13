package br.com.mind5.security.userPasswordSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class LazyUpswdarchMergeToSelect extends ActionLazyTemplate<UpswdarchInfo, UpswdarchInfo> {
	
	public LazyUpswdarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UpswdarchInfo> translateRecordInfosHook(List<UpswdarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UpswdarchInfo> getInstanceOfActionHook(DeciTreeOption<UpswdarchInfo> option) {
		return new StdUpswdarchMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<UpswdarchInfo> translateResultHook(DeciResult<UpswdarchInfo> result) {
		return result;
	}
}
