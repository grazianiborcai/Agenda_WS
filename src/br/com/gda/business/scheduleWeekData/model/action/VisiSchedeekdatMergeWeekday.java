package br.com.gda.business.scheduleWeekData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedeekdatMergeWeekday extends ActionVisitorTemplateMergeV2<SchedeekdatInfo, WeekdayInfo> {

	public VisiSchedeekdatMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}

	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}

	
	
	@Override protected List<SchedeekdatInfo> mergeHook(List<SchedeekdatInfo> recordInfos, List<WeekdayInfo> selectedInfos) {
		return SchedeekdatMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}

	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
