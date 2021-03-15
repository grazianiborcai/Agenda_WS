package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree.RootStusorygrarchSelect;

public final class LazyStusorygrarchRootSelect extends ActionLazyTemplate<StusorygrarchInfo, StusorygrarchInfo> {

	public LazyStusorygrarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorygrarchInfo> translateRecordInfosHook(List<StusorygrarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorygrarchInfo> getInstanceOfActionHook(DeciTreeOption<StusorygrarchInfo> option) {
		return new RootStusorygrarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StusorygrarchInfo> translateResultHook(DeciResult<StusorygrarchInfo> result) {
		return result;
	}
}
