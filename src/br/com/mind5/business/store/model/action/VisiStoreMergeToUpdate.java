package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreCopier;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreMergeToUpdate extends ActionVisitorTemplateMergeV2<StoreInfo, StoreInfo> {
	
	public VisiStoreMergeToUpdate(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoreInfo>> getActionClassHook() {
		return StdStoreDaoSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<StoreInfo> baseInfos) {
		return StoreCopier.copyFromStoreKey(baseInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {	
		return StoreMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}	
}
