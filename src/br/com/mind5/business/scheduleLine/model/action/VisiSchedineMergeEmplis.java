package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisCopier;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeEmplis extends ActionVisitorTemplateMergeV2<SchedineInfo, EmplisInfo> {
	
	public VisiSchedineMergeEmplis(DeciTreeOption<SchedineInfo> option) {
		super(option, EmplisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> toActionClassHook(List<SchedineInfo> baseInfos) {
		return EmplisCopier.copyFromSchedine(baseInfos);	
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return SchedineMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
