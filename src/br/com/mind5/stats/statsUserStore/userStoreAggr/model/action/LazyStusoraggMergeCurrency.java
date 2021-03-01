package br.com.mind5.stats.statsUserStore.userStoreAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

public final class LazyStusoraggMergeCurrency extends ActionLazyTemplate<StusoraggInfo, StusoraggInfo> {

	public LazyStusoraggMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusoraggInfo> translateRecordInfosHook(List<StusoraggInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusoraggInfo> getInstanceOfActionHook(DeciTreeOption<StusoraggInfo> option) {
		return new StdStusoreveMergeCurrency(option);
	}
	
	
	
	@Override protected DeciResult<StusoraggInfo> translateResultHook(DeciResult<StusoraggInfo> result) {
		return result;
	}
}
