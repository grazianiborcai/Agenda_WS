package br.com.mind5.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.RootStowotmSearch;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStowotmRootSearch extends ActionLazyTemplateV2<StowotmInfo, StowotmInfo> {
	
	public LazyStowotmRootSearch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StowotmInfo> translateRecordInfosHook(List<StowotmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StowotmInfo> getInstanceOfActionHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmSearch(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StowotmInfo> translateResultHook(DeciResult<StowotmInfo> result) {
		return result;
	}
}
