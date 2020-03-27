package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpwotmMergeToSelect extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwotmInfo> {
	
	public VisiEmpwotmMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwotmInfo>> getActionClassHook() {
		return StdEmpwotmSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {	
		return EmpwotmMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
