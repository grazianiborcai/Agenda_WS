package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmpwoutMergeToSelect extends ActionVisitorTemplateMerge<EmpwoutInfo, EmpwoutInfo> {
	
	public VisiEmpwoutMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwoutInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwoutInfo>> getActionClassHook() {
		return StdEmpwoutSelect.class;
	}
	
	
	
	@Override protected List<EmpwoutInfo> mergeHook(List<EmpwoutInfo> recordInfos, List<EmpwoutInfo> selectedInfos) {	
		return EmpwoutMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
