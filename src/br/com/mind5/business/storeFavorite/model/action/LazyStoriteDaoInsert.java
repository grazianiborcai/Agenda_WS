package br.com.mind5.business.storeFavorite.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public final class LazyStoriteDaoInsert extends ActionLazyTemplate<StoriteInfo, StoriteInfo> {
	
	public LazyStoriteDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoriteInfo> translateRecordInfosHook(List<StoriteInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoriteInfo> getInstanceOfActionHook(DeciTreeOption<StoriteInfo> option) {
		return new StdStoriteDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<StoriteInfo> translateResultHook(DeciResult<StoriteInfo> result) {
		return result;
	}
}
