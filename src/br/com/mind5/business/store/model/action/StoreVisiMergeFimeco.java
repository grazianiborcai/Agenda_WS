package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.decisionTree.FimecoRootSelectByStore;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeFimeco extends ActionVisitorTemplateMerge<StoreInfo, FimecoInfo> {
	
	public StoreVisiMergeFimeco(DeciTreeOption<StoreInfo> option) {
		super(option, FimecoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimecoInfo>> getTreeClassHook() {
		return FimecoRootSelectByStore.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<FimecoInfo> selectedInfos) {	
		return StoreMerger.mergeWithFimeco(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
