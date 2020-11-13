package br.com.mind5.business.storeFavorite.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.RootStoriteSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStoriteRootSelect extends ActionLazyTemplate<StoriteInfo, StoriteInfo> {
	
	public LazyStoriteRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoriteInfo> translateRecordInfosHook(List<StoriteInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoriteInfo> getInstanceOfActionHook(DeciTreeOption<StoriteInfo> option) {
		return new RootStoriteSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoriteInfo> translateResultHook(DeciResult<StoriteInfo> result) {
		return result;
	}
}
