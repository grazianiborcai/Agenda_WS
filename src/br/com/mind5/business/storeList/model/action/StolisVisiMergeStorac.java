package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.model.decisionTree.StoracRootSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolisVisiMergeStorac extends ActionVisitorTemplateMerge<StolisInfo, StoracInfo> {
	
	public StolisVisiMergeStorac(DeciTreeOption<StolisInfo> option) {
		super(option, StoracInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoracInfo>> getTreeClassHook() {
		return StoracRootSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<StoracInfo> selectedInfos) {	
		return StolisMerger.mergeWithStorac(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
