package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.business.personListRestricted.model.decisionTree.RootPersoresSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmplisMergePersores extends ActionVisitorTemplateMergeV2<EmplisInfo, PersoresInfo> {
	
	public VisiEmplisMergePersores(Connection conn, String schemaName) {
		super(conn, schemaName, PersoresInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersoresInfo>> getTreeClassHook() {
		return RootPersoresSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> baseInfos, List<PersoresInfo> selectedInfos) {	
		return EmplisMerger.mergeWithPersores(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
