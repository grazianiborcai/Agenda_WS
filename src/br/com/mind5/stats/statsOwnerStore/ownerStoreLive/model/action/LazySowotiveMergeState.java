package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;

public final class LazySowotiveMergeState extends ActionLazyTemplate<SowotiveInfo, SowotiveInfo> {

	public LazySowotiveMergeState(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowotiveInfo> translateRecordInfosHook(List<SowotiveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowotiveInfo> getInstanceOfActionHook(DeciTreeOption<SowotiveInfo> option) {
		return new StdSowotiveMergeState(option);
	}
	
	
	
	@Override protected DeciResult<SowotiveInfo> translateResultHook(DeciResult<SowotiveInfo> result) {
		return result;
	}
}
