package br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyBostodMergeStolis extends ActionLazyTemplate<BostodInfo, BostodInfo> {

	public LazyBostodMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<BostodInfo> translateRecordInfosHook(List<BostodInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<BostodInfo> getInstanceOfActionHook(DeciTreeOption<BostodInfo> option) {
		return new StdBostodMergeStolis(option);
	}
	
	
	
	@Override protected DeciResult<BostodInfo> translateResultHook(DeciResult<BostodInfo> result) {
		return result;
	}
}
