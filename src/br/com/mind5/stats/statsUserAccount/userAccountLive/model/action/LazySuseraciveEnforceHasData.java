package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

public final class LazySuseraciveEnforceHasData extends ActionLazyTemplate<SuseraciveInfo, SuseraciveInfo> {

	public LazySuseraciveEnforceHasData(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SuseraciveInfo> translateRecordInfosHook(List<SuseraciveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SuseraciveInfo> getInstanceOfActionHook(DeciTreeOption<SuseraciveInfo> option) {
		return new StdSuseraciveEnforceHasData(option);
	}
	
	
	
	@Override protected DeciResult<SuseraciveInfo> translateResultHook(DeciResult<SuseraciveInfo> result) {
		return result;
	}
}
