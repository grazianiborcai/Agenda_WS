package br.com.mind5.business.storeFavorite.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.RootStoriteDelete;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStoriteRootDelete extends ActionLazyTemplate<StoriteInfo, StoriteInfo> {
	
	public LazyStoriteRootDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoriteInfo> translateRecordInfosHook(List<StoriteInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoriteInfo> getInstanceOfActionHook(DeciTreeOption<StoriteInfo> option) {
		return new RootStoriteDelete(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoriteInfo> translateResultHook(DeciResult<StoriteInfo> result) {
		return result;
	}
}
