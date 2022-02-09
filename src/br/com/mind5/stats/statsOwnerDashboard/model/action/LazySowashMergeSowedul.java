package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;

public final class LazySowashMergeSowedul extends ActionLazyTemplate<SowashInfo, SowashInfo> {

	public LazySowashMergeSowedul(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowashInfo> translateRecordInfosHook(List<SowashInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowashInfo> getInstanceOfActionHook(DeciTreeOption<SowashInfo> option) {
		return new StdSowashMergeSowedul(option);
	}
	
	
	
	@Override protected DeciResult<SowashInfo> translateResultHook(DeciResult<SowashInfo> result) {
		return result;
	}
}
