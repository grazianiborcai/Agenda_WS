package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiEmpwoutMergeToSelect extends ActionVisitorTemplateMergeV1<EmpwoutInfo, EmpwoutInfo> {
	
	public VisiEmpwoutMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwoutInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmpwoutInfo>> getActionClassHook() {
		return StdEmpwoutSelect.class;
	}
	
	
	
	@Override protected List<EmpwoutInfo> mergeHook(List<EmpwoutInfo> recordInfos, List<EmpwoutInfo> selectedInfos) {	
		return EmpwoutMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
