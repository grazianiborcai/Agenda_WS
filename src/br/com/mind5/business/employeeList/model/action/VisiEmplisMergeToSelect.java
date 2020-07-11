package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplisMergeToSelect extends ActionVisitorTemplateMergeV2<EmplisInfo, EmplisInfo> {
	
	public VisiEmplisMergeToSelect(DeciTreeOption<EmplisInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmplisInfo>> getActionClassHook() {
		return StdEmplisDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return EmplisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
