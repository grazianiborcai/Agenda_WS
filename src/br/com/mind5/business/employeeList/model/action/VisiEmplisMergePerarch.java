package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.business.personSearch.info.PerarchCopier;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectEmp;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmplisMergePerarch extends ActionVisitorTemplateMergeV2<EmplisInfo, PerarchInfo> {
	
	public VisiEmplisMergePerarch(Connection conn, String schemaName) {
		super(conn, schemaName, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerarchInfo>> getTreeClassHook() {
		return RootPerarchSelectEmp.class;
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<EmplisInfo> recordInfos) {
		return PerarchCopier.copyFromEmplis(recordInfos);	
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> recordInfos, List<PerarchInfo> selectedInfos) {	
		return EmplisMerger.mergeWithPerarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
