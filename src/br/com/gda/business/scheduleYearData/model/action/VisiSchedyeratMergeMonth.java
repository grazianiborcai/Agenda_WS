package br.com.gda.business.scheduleYearData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMonthSelect;
import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.business.scheduleYearData.info.SchedyeratMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

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
