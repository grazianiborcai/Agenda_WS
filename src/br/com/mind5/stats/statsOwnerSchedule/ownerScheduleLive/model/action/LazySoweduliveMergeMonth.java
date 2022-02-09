package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveInfo;

public final class LazySoweduliveMergeMonth extends ActionLazyTemplate<SoweduliveInfo, SoweduliveInfo> {

	public LazySoweduliveMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SoweduliveInfo> translateRecordInfosHook(List<SoweduliveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SoweduliveInfo> getInstanceOfActionHook(DeciTreeOption<SoweduliveInfo> option) {
		return new StdSoweduliveMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<SoweduliveInfo> translateResultHook(DeciResult<SoweduliveInfo> result) {
		return result;
	}
}
