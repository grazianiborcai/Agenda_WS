package br.com.gda.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMonthSelect;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedonthatMergeMonth extends ActionVisitorTemplateMergeV2<SchedonthatInfo, MonthInfo> {

	public VisiSchedonthatMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName, MonthInfo.class);
	}

	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}

	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> recordInfos, List<MonthInfo> selectedInfos) {
		return SchedonthatMerger.mergeWithMonth(selectedInfos, recordInfos);
	}

	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
