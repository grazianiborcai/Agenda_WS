package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;

public final class LazyStusorygeDaoInsert extends ActionLazyTemplate<StusorygeInfo, StusorygeInfo> {

	public LazyStusorygeDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorygeInfo> translateRecordInfosHook(List<StusorygeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorygeInfo> getInstanceOfActionHook(DeciTreeOption<StusorygeInfo> option) {
		return new StdStusorygeDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<StusorygeInfo> translateResultHook(DeciResult<StusorygeInfo> result) {
		return result;
	}
}
