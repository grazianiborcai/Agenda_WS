package br.com.mind5.business.employeeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmparchMergeToSelect extends ActionVisitorTemplateMerge<EmparchInfo, EmparchInfo> {
	
	public VisiEmparchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmparchInfo>> getActionClassHook() {
		return StdEmparchSelect.class;
	}
	
	
	
	@Override protected List<EmparchInfo> mergeHook(List<EmparchInfo> baseInfos, List<EmparchInfo> selectedInfos) {	
		return EmparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
