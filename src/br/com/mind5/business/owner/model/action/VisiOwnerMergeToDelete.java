package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerMergeToDelete extends ActionVisitorTemplateMergeV2<OwnerInfo, OwnerInfo> {
	
	public VisiOwnerMergeToDelete(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OwnerInfo>> getActionClassHook() {
		return StdOwnerDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {	
		return OwnerMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
