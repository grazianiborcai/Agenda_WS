package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.decisionTree.RootStusorygeUpsert;

public final class LazyStusorygeRootUpsert extends ActionLazyTemplate<StusorygeInfo, StusorygeInfo> {

	public LazyStusorygeRootUpsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorygeInfo> translateRecordInfosHook(List<StusorygeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorygeInfo> getInstanceOfActionHook(DeciTreeOption<StusorygeInfo> option) {
		return new RootStusorygeUpsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StusorygeInfo> translateResultHook(DeciResult<StusorygeInfo> result) {
		return result;
	}
}
