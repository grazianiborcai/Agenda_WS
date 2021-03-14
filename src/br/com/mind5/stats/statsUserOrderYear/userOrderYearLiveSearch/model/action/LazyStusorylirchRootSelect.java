package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.decisionTree.RootStusorylirchSelect;

public final class LazyStusorylirchRootSelect extends ActionLazyTemplate<StusorylirchInfo, StusorylirchInfo> {

	public LazyStusorylirchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorylirchInfo> translateRecordInfosHook(List<StusorylirchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorylirchInfo> getInstanceOfActionHook(DeciTreeOption<StusorylirchInfo> option) {
		return new RootStusorylirchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StusorylirchInfo> translateResultHook(DeciResult<StusorylirchInfo> result) {
		return result;
	}
}
