package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class LazySoweduliveMergeState extends ActionLazyTemplate<SoweduliveInfo, SoweduliveInfo> {

	public LazySoweduliveMergeState(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SoweduliveInfo> translateRecordInfosHook(List<SoweduliveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SoweduliveInfo> getInstanceOfActionHook(DeciTreeOption<SoweduliveInfo> option) {
		return new StdSoweduliveMergeState(option);
	}
	
	
	
	@Override protected DeciResult<SoweduliveInfo> translateResultHook(DeciResult<SoweduliveInfo> result) {
		return result;
	}
}
