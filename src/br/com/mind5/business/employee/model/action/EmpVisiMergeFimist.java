package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.FimistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiMergeFimist extends ActionVisitorTemplateMerge<EmpInfo, FimistInfo> {
	
	public EmpVisiMergeFimist(DeciTreeOption<EmpInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return FimistRootSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<EmpInfo> baseInfos) {
		return FimistCopier.copyFromEmp(baseInfos);	
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return EmpMerger.mergeWithFimist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
