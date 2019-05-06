package br.com.gda.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpwocoMergeToSelect extends ActionVisitorTemplateMergeV2<EmpwocoInfo, EmpwocoInfo> {
	
	public VisiEmpwocoMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwocoInfo>> getActionClassHook() {
		return StdEmpwocoSelect.class;
	}
	
	
	
	@Override protected List<EmpwocoInfo> mergeHook(List<EmpwocoInfo> recordInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwocoMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
