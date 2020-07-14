package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpnapMergeToSelect extends ActionVisitorTemplateMergeV2<EmpnapInfo, EmpnapInfo> {
	
	public VisiEmpnapMergeToSelect(DeciTreeOption<EmpnapInfo> option) {
		super(option, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmpnapInfo>> getActionClassHook() {
		return StdEmpnapDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> baseInfos, List<EmpnapInfo> selectedInfos) {	
		return EmpnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
