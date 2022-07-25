package br.com.mind5.stats.statsUserStore.userStoreAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggMerger;

public final class StusoraggVisiMergeToSelect extends ActionVisitorTemplateMerge<StusoraggInfo, StusoraggInfo> {
	
	public StusoraggVisiMergeToSelect(DeciTreeOption<StusoraggInfo> option) {
		super(option, StusoraggInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusoraggInfo>> getVisitorClassHook() {
		return StusoraggVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusoraggInfo> mergeHook(List<StusoraggInfo> baseInfos, List<StusoraggInfo> selectedInfos) {	
		return StusoraggMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
