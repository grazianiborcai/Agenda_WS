package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeToDelete extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwotmInfo> {
	
	public VisiEmpwotmMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return RootEmpwotmSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> recordInfos, List<EmpwotmInfo> selectedInfos) {	
		return EmpwotmMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
