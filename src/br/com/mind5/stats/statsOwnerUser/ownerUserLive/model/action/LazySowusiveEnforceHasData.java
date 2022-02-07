package br.com.mind5.stats.statsOwnerUser.ownerUserLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;

public final class LazySowusiveEnforceHasData extends ActionLazyTemplate<SowusiveInfo, SowusiveInfo> {

	public LazySowusiveEnforceHasData(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowusiveInfo> translateRecordInfosHook(List<SowusiveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowusiveInfo> getInstanceOfActionHook(DeciTreeOption<SowusiveInfo> option) {
		return new StdSowusiveEnforceHasData(option);
	}
	
	
	
	@Override protected DeciResult<SowusiveInfo> translateResultHook(DeciResult<SowusiveInfo> result) {
		return result;
	}
}
