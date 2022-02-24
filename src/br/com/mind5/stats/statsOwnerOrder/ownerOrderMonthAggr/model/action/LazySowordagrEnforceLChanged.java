package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

public final class LazySowordagrEnforceLChanged extends ActionLazyTemplate<SowordagrInfo, SowordagrInfo> {

	public LazySowordagrEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowordagrInfo> translateRecordInfosHook(List<SowordagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowordagrInfo> getInstanceOfActionHook(DeciTreeOption<SowordagrInfo> option) {
		return new StdSowordagrEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<SowordagrInfo> translateResultHook(DeciResult<SowordagrInfo> result) {
		return result;
	}
}
