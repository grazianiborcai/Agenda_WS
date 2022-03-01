package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalMerger;

public final class SowalVisiMergeStolis extends ActionVisitorTemplateMerge<SowalInfo, StolisInfo> {
	
	public SowalVisiMergeStolis(DeciTreeOption<SowalInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSearch.class;
	}
	
	
	
	@Override protected List<SowalInfo> mergeHook(List<SowalInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return SowalMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
