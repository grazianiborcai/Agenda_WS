package br.com.mind5.business.scheduleWeekData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMonthSelect;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedeekdatMergeMonth extends ActionVisitorTemplateMergeV2<SchedeekdatInfo, MonthInfo> {

	public VisiSchedeekdatMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName, MonthInfo.class);
	}

	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}

	
	
	@Override protected List<SchedeekdatInfo> mergeHook(List<SchedeekdatInfo> recordInfos, List<MonthInfo> selectedInfos) {
		return SchedeekdatMerger.mergeWithMonth(selectedInfos, recordInfos);
	}

	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
