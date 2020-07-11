package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.RootFimistSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplisMergeFimist extends ActionVisitorTemplateMergeV2<EmplisInfo, FimistInfo> {
	
	public VisiEmplisMergeFimist(DeciTreeOption<EmplisInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<EmplisInfo> baseInfos) {
		return FimistCopier.copyFromEmplis(baseInfos);	
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return EmplisMerger.mergeWithFimist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
