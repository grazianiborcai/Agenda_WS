package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

public final class LazyStoraciveMergeMonth extends ActionLazyTemplate<StoraciveInfo, StoraciveInfo> {

	public LazyStoraciveMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoraciveInfo> translateRecordInfosHook(List<StoraciveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoraciveInfo> getInstanceOfActionHook(DeciTreeOption<StoraciveInfo> option) {
		return new StdStoraciveMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<StoraciveInfo> translateResultHook(DeciResult<StoraciveInfo> result) {
		return result;
	}
}
