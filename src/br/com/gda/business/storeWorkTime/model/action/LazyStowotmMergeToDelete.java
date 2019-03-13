package br.com.gda.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStowotmMergeToDelete extends ActionLazyTemplate<StowotmInfo, StowotmInfo> {
	
	public LazyStowotmMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StowotmInfo> translateRecordInfosHook(List<StowotmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> getInstanceOfActionHook(DeciTreeOption<StowotmInfo> option) {
		return new StdStowotmMergeToDelete(option);
	}
	
	
	
	@Override protected DeciResult<StowotmInfo> translateResultHook(DeciResult<StowotmInfo> result) {
		return result;
	}
}
