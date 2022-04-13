package br.com.mind5.business.storeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmapVisiMergeToSelect extends ActionVisitorTemplateMerge<StuntmapInfo, StuntmapInfo> {
	
	public StuntmapVisiMergeToSelect(DeciTreeOption<StuntmapInfo> option) {
		super(option, StuntmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StuntmapInfo>> getVisitorClassHook() {
		return StuntmapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StuntmapInfo> mergeHook(List<StuntmapInfo> baseInfos, List<StuntmapInfo> selectedInfos) {	
		return StuntmapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
