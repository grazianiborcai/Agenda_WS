package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpMergeToUpdate extends ActionVisitorTemplateMergeV2<EmpInfo, EmpInfo> {
	
	public VisiEmpMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpInfo>> getActionClassHook() {
		return StdEmpSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {	
		return EmpMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
