package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.RootComplisSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolisMergeComplis extends ActionVisitorTemplateMerge<StolisInfo, ComplisInfo> {
	
	public VisiStolisMergeComplis(DeciTreeOption<StolisInfo> option) {
		super(option, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return RootComplisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<ComplisInfo> selectedInfos) {	
		return StolisMerger.mergeWithComplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
