package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.business.personSnapshot.info.PersonapCopier;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class VisiEmpnapMergePersonap extends ActionVisitorTemplateMerge<EmpnapInfo, PersonapInfo> {
	
	public VisiEmpnapMergePersonap(DeciTreeOption<EmpnapInfo> option) {
		super(option, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return RootPersonapSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<EmpnapInfo> baseInfos) {
		return PersonapCopier.copyFromEmpnapKey(baseInfos);	
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> baseInfos, List<PersonapInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithPersonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
