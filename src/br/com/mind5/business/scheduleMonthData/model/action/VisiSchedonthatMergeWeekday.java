package br.com.mind5.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedonthatMergeWeekday extends ActionVisitorTemplateMergeV1<SchedonthatInfo, WeekdayInfo> {

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
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
