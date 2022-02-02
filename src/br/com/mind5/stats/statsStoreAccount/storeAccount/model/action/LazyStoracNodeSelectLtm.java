package br.com.mind5.stats.statsStoreAccount.storeAccount.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.decisionTree.NodeStoracSelectLtm;

public final class LazyStoracNodeSelectLtm extends ActionLazyTemplate<StoracInfo, StoracInfo> {

	public LazyStoracNodeSelectLtm(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoracInfo> translateRecordInfosHook(List<StoracInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoracInfo> getInstanceOfActionHook(DeciTreeOption<StoracInfo> option) {
		return new NodeStoracSelectLtm(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoracInfo> translateResultHook(DeciResult<StoracInfo> result) {
		return result;
	}
}
