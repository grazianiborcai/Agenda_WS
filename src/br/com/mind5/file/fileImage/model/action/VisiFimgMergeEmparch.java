package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.RootEmparchSelectUser;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgMergeEmparch extends ActionVisitorTemplateMerge<FimgInfo, EmparchInfo> {
	
	public VisiFimgMergeEmparch(DeciTreeOption<FimgInfo> option) {
		super(option, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmparchInfo>> getTreeClassHook() {
		return RootEmparchSelectUser.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<EmparchInfo> selectedInfos) {	
		return FimgMerger.mergeWithEmparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
