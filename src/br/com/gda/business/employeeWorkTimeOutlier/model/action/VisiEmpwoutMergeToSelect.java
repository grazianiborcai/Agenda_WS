package br.com.gda.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpwoutMergeToSelect extends ActionVisitorTemplateMergeV2<EmpwoutInfo, EmpwoutInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
