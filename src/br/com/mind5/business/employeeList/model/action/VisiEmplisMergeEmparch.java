package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.RootEmparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmplisMergeEmparch extends ActionVisitorTemplateMergeV2<EmplisInfo, EmparchInfo> {
	
	public VisiEmplisMergeEmparch(Connection conn, String schemaName) {
		super(conn, schemaName, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmparchInfo>> getTreeClassHook() {
		return RootEmparchSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> recordInfos, List<EmparchInfo> selectedInfos) {	
		return EmplisMerger.mergeWithEmparch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
