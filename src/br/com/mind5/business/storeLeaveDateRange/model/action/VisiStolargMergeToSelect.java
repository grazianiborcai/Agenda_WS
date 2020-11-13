package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolargMergeToSelect extends ActionVisitorTemplateMerge<StolargInfo, StolargInfo> {
	
	public VisiStolargMergeToSelect(DeciTreeOption<StolargInfo> option) {
		super(option, StolargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolargInfo>> getActionClassHook() {
		return StdStolargDaoSelect.class;
	}
	
	
	
	@Override protected List<StolargInfo> mergeHook(List<StolargInfo> baseInfos, List<StolargInfo> selectedInfos) {	
		return StolargMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
