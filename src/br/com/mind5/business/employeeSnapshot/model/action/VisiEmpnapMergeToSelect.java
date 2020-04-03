package br.com.mind5.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiEmpnapMergeToSelect extends ActionVisitorTemplateMergeV1<EmpnapInfo, EmpnapInfo> {
	
	public VisiEmpnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmpnapInfo>> getActionClassHook() {
		return StdEmpnapSelect.class;
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> recordInfos, List<EmpnapInfo> selectedInfos) {	
		return EmpnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
