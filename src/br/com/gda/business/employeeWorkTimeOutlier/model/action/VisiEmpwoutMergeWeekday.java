package br.com.gda.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

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
