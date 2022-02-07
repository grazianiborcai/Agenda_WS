package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.decisionTree.RootStoraciveSelect;

public final class LazyStoraciveRootSelect extends ActionLazyTemplate<StoraciveInfo, StoraciveInfo> {

	public LazyStoraciveRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoraciveInfo> translateRecordInfosHook(List<StoraciveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoraciveInfo> getInstanceOfActionHook(DeciTreeOption<StoraciveInfo> option) {
		return new RootStoraciveSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoraciveInfo> translateResultHook(DeciResult<StoraciveInfo> result) {
		return result;
	}
}
