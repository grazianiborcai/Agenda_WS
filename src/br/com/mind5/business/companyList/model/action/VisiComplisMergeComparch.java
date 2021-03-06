package br.com.mind5.business.companyList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.info.ComplisMerger;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.model.decisionTree.RootComparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiComplisMergeComparch extends ActionVisitorTemplateMerge<ComplisInfo, ComparchInfo> {
	
	public VisiComplisMergeComparch(DeciTreeOption<ComplisInfo> option) {
		super(option, ComparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComparchInfo>> getTreeClassHook() {
		return RootComparchSelect.class;
	}
	
	
	
	@Override protected List<ComplisInfo> mergeHook(List<ComplisInfo> baseInfos, List<ComparchInfo> selectedInfos) {	
		return ComplisMerger.mergeWithComparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
