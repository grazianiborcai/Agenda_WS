package br.com.mind5.security.userPasswordSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class LazyUpswdarchMergeToSelect extends ActionLazyTemplateV2<UpswdarchInfo, UpswdarchInfo> {
	
	public LazyUpswdarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UpswdarchInfo> translateRecordInfosHook(List<UpswdarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UpswdarchInfo> getInstanceOfActionHook(DeciTreeOption<UpswdarchInfo> option) {
		return new StdUpswdarchMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<UpswdarchInfo> translateResultHook(DeciResult<UpswdarchInfo> result) {
		return result;
	}
}
