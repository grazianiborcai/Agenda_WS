package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree.RootSowordSelect;

public final class LazySowordRootSelect extends ActionLazyTemplate<SowordInfo, SowordInfo> {

	public LazySowordRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowordInfo> translateRecordInfosHook(List<SowordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowordInfo> getInstanceOfActionHook(DeciTreeOption<SowordInfo> option) {
		return new RootSowordSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowordInfo> translateResultHook(DeciResult<SowordInfo> result) {
		return result;
	}
}
