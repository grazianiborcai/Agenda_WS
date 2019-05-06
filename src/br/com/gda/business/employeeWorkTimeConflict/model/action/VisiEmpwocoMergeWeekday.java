package br.com.gda.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwocoMergeWeekday extends ActionVisitorTemplateMergeV2<EmpwocoInfo, WeekdayInfo> {
	
	public VisiEmpwocoMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<EmpwocoInfo> mergeHook(List<EmpwocoInfo> recordInfos, List<WeekdayInfo> selectedInfos) {	
		return EmpwocoMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
