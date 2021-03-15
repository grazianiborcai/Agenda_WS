package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.decisionTree.RootStusorySelect;

public final class LazyStusoryRootSelect extends ActionLazyTemplate<StusoryInfo, StusoryInfo> {

	public LazyStusoryRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusoryInfo> translateRecordInfosHook(List<StusoryInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusoryInfo> getInstanceOfActionHook(DeciTreeOption<StusoryInfo> option) {
		return new RootStusorySelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StusoryInfo> translateResultHook(DeciResult<StusoryInfo> result) {
		return result;
	}
}
