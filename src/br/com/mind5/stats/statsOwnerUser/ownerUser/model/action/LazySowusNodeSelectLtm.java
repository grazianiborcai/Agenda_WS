package br.com.mind5.stats.statsOwnerUser.ownerUser.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.decisionTree.NodeSowusSelectLtm;

public final class LazySowusNodeSelectLtm extends ActionLazyTemplate<SowusInfo, SowusInfo> {

	public LazySowusNodeSelectLtm(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowusInfo> translateRecordInfosHook(List<SowusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowusInfo> getInstanceOfActionHook(DeciTreeOption<SowusInfo> option) {
		return new NodeSowusSelectLtm(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowusInfo> translateResultHook(DeciResult<SowusInfo> result) {
		return result;
	}
}
