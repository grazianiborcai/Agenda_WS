package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;

public final class LazyStusoryrchMergeStusorygerch extends ActionLazyTemplate<StusoryrchInfo, StusoryrchInfo> {

	public LazyStusoryrchMergeStusorygerch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusoryrchInfo> translateRecordInfosHook(List<StusoryrchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusoryrchInfo> getInstanceOfActionHook(DeciTreeOption<StusoryrchInfo> option) {
		return new StdStusoryrchMergeStusorygerch(option);
	}
	
	
	
	@Override protected DeciResult<StusoryrchInfo> translateResultHook(DeciResult<StusoryrchInfo> result) {
		return result;
	}
}
