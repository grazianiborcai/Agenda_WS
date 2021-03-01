package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree.RootStusorygerchSelect;

public final class LazyStusorygerchRootSelect extends ActionLazyTemplate<StusorygerchInfo, StusorygerchInfo> {

	public LazyStusorygerchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorygerchInfo> translateRecordInfosHook(List<StusorygerchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorygerchInfo> getInstanceOfActionHook(DeciTreeOption<StusorygerchInfo> option) {
		return new RootStusorygerchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StusorygerchInfo> translateResultHook(DeciResult<StusorygerchInfo> result) {
		return result;
	}
}
