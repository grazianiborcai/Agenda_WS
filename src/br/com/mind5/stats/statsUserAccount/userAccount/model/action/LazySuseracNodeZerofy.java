package br.com.mind5.stats.statsUserAccount.userAccount.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.model.decisionTree.NodeSuseracZerofy;

public final class LazySuseracNodeZerofy extends ActionLazyTemplate<SuseracInfo, SuseracInfo> {

	public LazySuseracNodeZerofy(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SuseracInfo> translateRecordInfosHook(List<SuseracInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SuseracInfo> getInstanceOfActionHook(DeciTreeOption<SuseracInfo> option) {
		return new NodeSuseracZerofy(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SuseracInfo> translateResultHook(DeciResult<SuseracInfo> result) {
		return result;
	}
}
