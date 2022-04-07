package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.materialGroupStore.model.decisionTree.MatoporeRootSelect;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiMergeMatopore extends ActionVisitorTemplateMerge<StorbyInfo, MatoporeInfo> {
	
	public StorbyVisiMergeMatopore(DeciTreeOption<StorbyInfo> option) {
		super(option, MatoporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoporeInfo>> getTreeClassHook() {
		return MatoporeRootSelect.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<MatoporeInfo> selectedInfos) {	
		return StorbyMerger.mergeWithMatopore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
