package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.decisionTree.NodeSowotZerofy;

public final class LazySowotNodeZerofy extends ActionLazyTemplate<SowotInfo, SowotInfo> {

	public LazySowotNodeZerofy(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowotInfo> translateRecordInfosHook(List<SowotInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowotInfo> getInstanceOfActionHook(DeciTreeOption<SowotInfo> option) {
		return new NodeSowotZerofy(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowotInfo> translateResultHook(DeciResult<SowotInfo> result) {
		return result;
	}
}
