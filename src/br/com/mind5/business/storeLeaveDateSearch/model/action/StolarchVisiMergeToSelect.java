package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StolarchInfo, StolarchInfo> {
	
	public StolarchVisiMergeToSelect(DeciTreeOption<StolarchInfo> option) {
		super(option, StolarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StolarchInfo>> getVisitorClassHook() {
		return StolarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StolarchInfo> mergeHook(List<StolarchInfo> baseInfos, List<StolarchInfo> selectedInfos) {	
		return StolarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
