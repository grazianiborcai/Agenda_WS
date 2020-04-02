package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmpwocoMergeToSelect extends ActionVisitorTemplateMerge<EmpwocoInfo, EmpwocoInfo> {
	
	public VisiEmpwocoMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmpwocoInfo>> getActionClassHook() {
		return StdEmpwocoSelect.class;
	}
	
	
	
	@Override protected List<EmpwocoInfo> mergeHook(List<EmpwocoInfo> recordInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwocoMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
