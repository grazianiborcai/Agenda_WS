package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.decisionTree.RootFimecoSelectByStore;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyMergeFimeco extends ActionVisitorTemplateMerge<StorbyInfo, FimecoInfo> {
	
	public VisiStorbyMergeFimeco(DeciTreeOption<StorbyInfo> option) {
		super(option, FimecoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimecoInfo>> getTreeClassHook() {
		return RootFimecoSelectByStore.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<FimecoInfo> selectedInfos) {	
		return StorbyMerger.mergeWithFimeco(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
