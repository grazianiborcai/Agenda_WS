package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.decisionTree.RootSowordarchSelect;

public final class LazySowordarchRootSelect extends ActionLazyTemplate<SowordarchInfo, SowordarchInfo> {

	public LazySowordarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowordarchInfo> translateRecordInfosHook(List<SowordarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowordarchInfo> getInstanceOfActionHook(DeciTreeOption<SowordarchInfo> option) {
		return new RootSowordarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowordarchInfo> translateResultHook(DeciResult<SowordarchInfo> result) {
		return result;
	}
}
