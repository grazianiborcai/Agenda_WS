package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeewnerVisiMergeToSelect extends ActionVisitorTemplateMerge<FeewnerInfo, FeewnerInfo> {

	public FeewnerVisiMergeToSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FeewnerInfo>> getVisitorClassHook() {
		return FeewnerVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> mergeHook(List<FeewnerInfo> baseInfos, List<FeewnerInfo> selectedInfos) {	
		return FeewnerMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
