package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

public final class LazyUseraciveMergeState extends ActionLazyTemplate<UseraciveInfo, UseraciveInfo> {

	public LazyUseraciveMergeState(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UseraciveInfo> translateRecordInfosHook(List<UseraciveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UseraciveInfo> getInstanceOfActionHook(DeciTreeOption<UseraciveInfo> option) {
		return new StdUseraciveMergeState(option);
	}
	
	
	
	@Override protected DeciResult<UseraciveInfo> translateResultHook(DeciResult<UseraciveInfo> result) {
		return result;
	}
}
