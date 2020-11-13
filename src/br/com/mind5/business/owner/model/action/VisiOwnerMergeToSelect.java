package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerMergeToSelect extends ActionVisitorTemplateMerge<OwnerInfo, OwnerInfo> {
	
	public VisiOwnerMergeToSelect(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnerInfo>> getActionClassHook() {
		return StdOwnerDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {	
		return OwnerMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
