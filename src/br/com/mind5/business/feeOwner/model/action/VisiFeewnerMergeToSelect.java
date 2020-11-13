package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeewnerMergeToSelect extends ActionVisitorTemplateMerge<FeewnerInfo, FeewnerInfo> {

	public VisiFeewnerMergeToSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FeewnerInfo>> getActionClassHook() {
		return StdFeewnerDaoSelect.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> mergeHook(List<FeewnerInfo> baseInfos, List<FeewnerInfo> selectedInfos) {	
		return FeewnerMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
