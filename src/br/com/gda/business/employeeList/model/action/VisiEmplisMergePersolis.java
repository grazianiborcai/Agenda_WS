package br.com.gda.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.info.EmplisMerger;
import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmplisMergePersolis extends ActionVisitorTemplateMergeV2<EmplisInfo, PersolisInfo> {
	
	public VisiEmplisMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return EmplisMerger.mergeWithPersolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
