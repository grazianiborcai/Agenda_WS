package br.com.gda.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.info.EmpnapMerger;
import br.com.gda.business.personSnapshot.info.PersonapCopier;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpnapMergePersonap extends ActionVisitorTemplateMergeV2<EmpnapInfo, PersonapInfo> {
	
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
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
