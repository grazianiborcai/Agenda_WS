package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwoutMergeWeekday extends ActionVisitorTemplateMergeV2<EmpwoutInfo, WeekdayInfo> {
	
	public VisiEmpwoutMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<EmpwoutInfo> mergeHook(List<EmpwoutInfo> recordInfos, List<WeekdayInfo> selectedInfos) {	
		return EmpwoutMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
