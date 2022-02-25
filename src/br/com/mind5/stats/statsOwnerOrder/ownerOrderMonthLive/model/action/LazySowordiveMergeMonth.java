package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;

public final class LazySowordiveMergeMonth extends ActionLazyTemplate<SowordiveInfo, SowordiveInfo> {

	public LazySowordiveMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowordiveInfo> translateRecordInfosHook(List<SowordiveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowordiveInfo> getInstanceOfActionHook(DeciTreeOption<SowordiveInfo> option) {
		return new StdSowordiveMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<SowordiveInfo> translateResultHook(DeciResult<SowordiveInfo> result) {
		return result;
	}
}
