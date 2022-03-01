package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrMerger;

public final class SowalagrVisiMergeToSelect extends ActionVisitorTemplateMerge<SowalagrInfo, SowalagrInfo> {
	
	public SowalagrVisiMergeToSelect(DeciTreeOption<SowalagrInfo> option) {
		super(option, SowalagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowalagrInfo>> getVisitorClassHook() {
		return SowalagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowalagrInfo> mergeHook(List<SowalagrInfo> baseInfos, List<SowalagrInfo> selectedInfos) {	
		return SowalagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
