package br.com.mind5.business.storeTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.info.StorextaultMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextaultMergeToSelect extends ActionVisitorTemplateMergeV2<StorextaultInfo, StorextaultInfo> {
	
	public VisiStorextaultMergeToSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option, StorextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StorextaultInfo>> getActionClassHook() {
		return StdStorextaultDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextaultInfo> toActionClassHook(List<StorextaultInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<StorextaultInfo> mergeHook(List<StorextaultInfo> baseInfos, List<StorextaultInfo> selectedInfos) {	
		return StorextaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
