package br.com.mind5.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.business.personSnapshot.info.PersonapCopier;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpnapMergePersonap extends ActionVisitorTemplateMerge<EmpnapInfo, PersonapInfo> {
	
	public VisiEmpnapMergePersonap(Connection conn, String schemaName) {
		super(conn, schemaName, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return RootPersonapSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<EmpnapInfo> recordInfos) {
		return PersonapCopier.copyFromEmpnapKey(recordInfos);	
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> recordInfos, List<PersonapInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithPersonap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
