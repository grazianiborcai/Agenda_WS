package br.com.mind5.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpnapMergeToSelect extends ActionVisitorTemplateMergeV2<EmpnapInfo, EmpnapInfo> {
	
	public VisiEmpnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpnapInfo>> getActionClassHook() {
		return StdEmpnapSelect.class;
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> recordInfos, List<EmpnapInfo> selectedInfos) {	
		return EmpnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
