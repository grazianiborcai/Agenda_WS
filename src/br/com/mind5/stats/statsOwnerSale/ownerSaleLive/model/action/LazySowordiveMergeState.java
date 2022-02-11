package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

public final class LazySowordiveMergeState extends ActionLazyTemplate<SowaliveInfo, SowaliveInfo> {

	public LazySowordiveMergeState(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowaliveInfo> translateRecordInfosHook(List<SowaliveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowaliveInfo> getInstanceOfActionHook(DeciTreeOption<SowaliveInfo> option) {
		return new StdSowordiveMergeState(option);
	}
	
	
	
	@Override protected DeciResult<SowaliveInfo> translateResultHook(DeciResult<SowaliveInfo> result) {
		return result;
	}
}
