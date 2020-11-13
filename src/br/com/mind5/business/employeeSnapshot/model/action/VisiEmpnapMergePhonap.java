package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.RootPhonapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpnapMergePhonap extends ActionVisitorTemplateMerge<EmpnapInfo, PhonapInfo> {
	
	public VisiEmpnapMergePhonap(DeciTreeOption<EmpnapInfo> option) {
		super(option, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return RootPhonapSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<EmpnapInfo> baseInfos) {
		return PhonapCopier.copyFromEmpnapKey(baseInfos);	
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> baseInfos, List<PhonapInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
