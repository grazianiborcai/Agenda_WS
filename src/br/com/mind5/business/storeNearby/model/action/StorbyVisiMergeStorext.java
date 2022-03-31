package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiMergeStorext extends ActionVisitorTemplateMerge<StorbyInfo, StorextInfo> {
	
	public StorbyVisiMergeStorext(DeciTreeOption<StorbyInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextRootSelect.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StorbyMerger.mergeWithStorext(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
