package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapMergeToSelect extends ActionVisitorTemplateMergeV2<StorapInfo, StorapInfo> {
	
	public VisiStorapMergeToSelect(DeciTreeOption<StorapInfo> option) {
		super(option, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StorapInfo>> getActionClassHook() {
		return StdStorapDaoSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<StorapInfo> selectedInfos) {	
		return StorapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
