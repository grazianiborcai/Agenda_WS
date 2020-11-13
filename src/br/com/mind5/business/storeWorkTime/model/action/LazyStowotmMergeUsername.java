package br.com.mind5.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStowotmMergeUsername extends ActionLazyTemplate<StowotmInfo, StowotmInfo> {
	
	public LazyStowotmMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StowotmInfo> translateRecordInfosHook(List<StowotmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StowotmInfo> getInstanceOfActionHook(DeciTreeOption<StowotmInfo> option) {
		return new StdStowotmMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<StowotmInfo> translateResultHook(DeciResult<StowotmInfo> result) {
		return result;
	}
}
