package br.com.gda.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateMerger;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmplevateMergeTimezone extends ActionVisitorTemplateMergeV2<EmplevateInfo, TimezoneInfo> {
	
	public VisiEmplevateMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected List<EmplevateInfo> mergeHook(List<EmplevateInfo> recordInfos, List<TimezoneInfo> selectedInfos) {	
		return EmplevateMerger.mergeWithTimezone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
