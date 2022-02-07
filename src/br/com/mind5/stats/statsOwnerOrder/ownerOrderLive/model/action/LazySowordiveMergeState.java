package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

public final class LazySowordiveMergeState extends ActionLazyTemplate<SowordiveInfo, SowordiveInfo> {

	public LazySowordiveMergeState(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowordiveInfo> translateRecordInfosHook(List<SowordiveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowordiveInfo> getInstanceOfActionHook(DeciTreeOption<SowordiveInfo> option) {
		return new StdSowordiveMergeState(option);
	}
	
	
	
	@Override protected DeciResult<SowordiveInfo> translateResultHook(DeciResult<SowordiveInfo> result) {
		return result;
	}
}
