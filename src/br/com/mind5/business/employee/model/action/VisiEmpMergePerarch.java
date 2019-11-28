package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.personSearch.info.PerarchCopier;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectEmp;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpMergePerarch extends ActionVisitorTemplateMergeV2<EmpInfo, PerarchInfo> {
	
	public VisiEmpMergePerarch(Connection conn, String schemaName) {
		super(conn, schemaName, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerarchInfo>> getTreeClassHook() {
		return RootPerarchSelectEmp.class;
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return PerarchCopier.copyFromEmp(recordInfos);	
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> recordInfos, List<PerarchInfo> selectedInfos) {	
		return EmpMerger.mergeWithPerarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
