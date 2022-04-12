package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolargVisiMergeToSelect extends ActionVisitorTemplateMerge<StolargInfo, StolargInfo> {
	
	public StolargVisiMergeToSelect(DeciTreeOption<StolargInfo> option) {
		super(option, StolargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StolargInfo>> getVisitorClassHook() {
		return StolargVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StolargInfo> mergeHook(List<StolargInfo> baseInfos, List<StolargInfo> selectedInfos) {	
		return StolargMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
