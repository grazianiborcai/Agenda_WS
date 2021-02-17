package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.decisionTree.RootFimecoSelectByStore;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolisMergeFimeco extends ActionVisitorTemplateMerge<StolisInfo, FimecoInfo> {
	
	public VisiStolisMergeFimeco(DeciTreeOption<StolisInfo> option) {
		super(option, FimecoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimecoInfo>> getTreeClassHook() {
		return RootFimecoSelectByStore.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<FimecoInfo> selectedInfos) {	
		return StolisMerger.mergeWithFimeco(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
