package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employee.model.decisionTree.RootEmpSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpMergeToDelete extends ActionVisitorTemplateMerge<EmpInfo, EmpInfo> {
	
	public VisiEmpMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return RootEmpSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {	
		return EmpMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
