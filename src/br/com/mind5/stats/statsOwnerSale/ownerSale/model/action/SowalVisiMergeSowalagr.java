package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalMerger;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.decisionTree.SowalagrRootSelect;

public final class SowalVisiMergeSowalagr extends ActionVisitorTemplateMerge<SowalInfo, SowalagrInfo> {
	
	public SowalVisiMergeSowalagr(DeciTreeOption<SowalInfo> option) {
		super(option, SowalagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowalagrInfo>> getTreeClassHook() {
		return SowalagrRootSelect.class;
	}
	
	
	
	@Override protected List<SowalInfo> mergeHook(List<SowalInfo> baseInfos, List<SowalagrInfo> selectedInfos) {	
		return SowalMerger.mergeWithSowalagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
