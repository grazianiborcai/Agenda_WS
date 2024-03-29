package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.model.decisionTree.FeedefRootSelectService;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeewnerVisiMergeFeedef extends ActionVisitorTemplateMerge<FeewnerInfo, FeedefInfo> {
	
	public FeewnerVisiMergeFeedef(DeciTreeOption<FeewnerInfo> option) {
		super(option, FeedefInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeedefInfo>> getTreeClassHook() {
		return FeedefRootSelectService.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> mergeHook(List<FeewnerInfo> baseInfos, List<FeedefInfo> selectedInfos) {	
		return FeewnerMerger.mergeWithFeedef(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
