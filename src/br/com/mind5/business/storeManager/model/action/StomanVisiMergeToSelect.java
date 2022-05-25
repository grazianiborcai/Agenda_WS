package br.com.mind5.business.storeManager.model.action;

import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeManager.info.StomanMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StomanVisiMergeToSelect extends ActionVisitorTemplateMerge<StomanInfo, StomanInfo> {
	
	public StomanVisiMergeToSelect(DeciTreeOption<StomanInfo> option) {
		super(option, StomanInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StomanInfo>> getVisitorClassHook() {
		return StomanVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StomanInfo> mergeHook(List<StomanInfo> baseInfos, List<StomanInfo> selectedInfos) {	
		return StomanMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
