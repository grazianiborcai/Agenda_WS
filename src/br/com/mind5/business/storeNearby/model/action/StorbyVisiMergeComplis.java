package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.ComplisRootSelect;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiMergeComplis extends ActionVisitorTemplateMerge<StorbyInfo, ComplisInfo> {
	
	public StorbyVisiMergeComplis(DeciTreeOption<StorbyInfo> option) {
		super(option, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return ComplisRootSelect.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<ComplisInfo> selectedInfos) {	
		return StorbyMerger.mergeWithComplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
