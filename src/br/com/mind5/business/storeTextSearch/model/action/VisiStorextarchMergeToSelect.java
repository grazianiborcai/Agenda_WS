package br.com.mind5.business.storeTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextarchMergeToSelect extends ActionVisitorTemplateMergeV2<StorextarchInfo, StorextarchInfo> {
	
	public VisiStorextarchMergeToSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option, StorextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StorextarchInfo>> getActionClassHook() {
		return StdStorextarchDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextarchInfo> toActionClassHook(List<StorextarchInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<StorextarchInfo> mergeHook(List<StorextarchInfo> baseInfos, List<StorextarchInfo> selectedInfos) {	
		return StorextarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
