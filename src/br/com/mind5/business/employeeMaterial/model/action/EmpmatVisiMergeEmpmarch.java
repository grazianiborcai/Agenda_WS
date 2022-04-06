package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatMerger;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.decisionTree.EmpmarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatVisiMergeEmpmarch extends ActionVisitorTemplateMerge<EmpmatInfo, EmpmarchInfo> {
	
	public EmpmatVisiMergeEmpmarch(DeciTreeOption<EmpmatInfo> option) {
		super(option, EmpmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmarchInfo>> getTreeClassHook() {
		return EmpmarchRootSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {	
		return EmpmatMerger.mergeWithEmpmarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
