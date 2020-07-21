package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerapMergeToSelect extends ActionVisitorTemplateMergeV2<OwnerapInfo, OwnerapInfo> {
	
	public VisiOwnerapMergeToSelect(DeciTreeOption<OwnerapInfo> option) {
		super(option, OwnerapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OwnerapInfo>> getActionClassHook() {
		return StdOwnerapDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> baseInfos, List<OwnerapInfo> selectedInfos) {	
		return OwnerapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
