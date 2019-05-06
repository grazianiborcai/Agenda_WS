package br.com.gda.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwocoMergeTimezone extends ActionVisitorTemplateMergeV2<EmpwocoInfo, TimezoneInfo> {
	
	public VisiEmpwocoMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected List<EmpwocoInfo> mergeHook(List<EmpwocoInfo> recordInfos, List<TimezoneInfo> selectedInfos) {	
		return EmpwocoMerger.mergeWithTimezone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
