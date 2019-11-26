package br.com.mind5.business.employeeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmparchMergeToSelect extends ActionVisitorTemplateMergeV2<EmparchInfo, EmparchInfo> {
	
	public VisiEmparchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmparchInfo>> getActionClassHook() {
		return StdEmparchSelect.class;
	}
	
	
	
	@Override protected List<EmparchInfo> mergeHook(List<EmparchInfo> recordInfos, List<EmparchInfo> selectedInfos) {	
		return EmparchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
