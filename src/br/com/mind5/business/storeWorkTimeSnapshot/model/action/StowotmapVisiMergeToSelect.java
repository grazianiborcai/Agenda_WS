package br.com.mind5.business.storeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmapVisiMergeToSelect extends ActionVisitorTemplateMerge<StowotmapInfo, StowotmapInfo> {
	
	public StowotmapVisiMergeToSelect(DeciTreeOption<StowotmapInfo> option) {
		super(option, StowotmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StowotmapInfo>> getVisitorClassHook() {
		return StowotmapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StowotmapInfo> mergeHook(List<StowotmapInfo> baseInfos, List<StowotmapInfo> selectedInfos) {	
		return StowotmapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
