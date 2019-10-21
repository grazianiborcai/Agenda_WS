package br.com.mind5.business.scheduleYearData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMonthSelect;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedyeratMergeMonth extends ActionVisitorTemplateMergeV2<SchedyeratInfo, MonthInfo> {
	
	public VisiSchedyeratMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<SchedyeratInfo> mergeHook(List<SchedyeratInfo> recordInfos, List<MonthInfo> selectedInfos) {	
		return SchedyeratMerger.mergeWithMonth(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
