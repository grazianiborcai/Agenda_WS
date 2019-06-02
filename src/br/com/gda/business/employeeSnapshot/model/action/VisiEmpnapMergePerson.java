package br.com.gda.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.info.EmpnapMerger;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpnapMergePerson extends ActionVisitorTemplateMergeV2<EmpnapInfo, PersonInfo> {
	
	public VisiEmpnapMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> recordInfos, List<PersonInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithPerson(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
