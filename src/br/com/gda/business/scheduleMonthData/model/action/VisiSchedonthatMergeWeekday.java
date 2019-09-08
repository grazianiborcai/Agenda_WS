package br.com.gda.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedonthatMergeWeekday extends ActionVisitorTemplateMergeV2<SchedonthatInfo, WeekdayInfo> {

	public VisiSchedonthatMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}

	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}

	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> recordInfos, List<WeekdayInfo> selectedInfos) {
		return SchedonthatMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}

	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
