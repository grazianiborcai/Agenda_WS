package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalMerger;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.decisionTree.SowaliveRootSelect;

public final class SowalVisiMergeSowalive extends ActionVisitorTemplateMerge<SowalInfo, SowaliveInfo> {
	
	public SowalVisiMergeSowalive(DeciTreeOption<SowalInfo> option) {
		super(option, SowaliveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowaliveInfo>> getTreeClassHook() {
		return SowaliveRootSelect.class;
	}
	
	
	
	@Override protected List<SowalInfo> mergeHook(List<SowalInfo> baseInfos, List<SowaliveInfo> selectedInfos) {	
		return SowalMerger.mergeWithSowalive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
