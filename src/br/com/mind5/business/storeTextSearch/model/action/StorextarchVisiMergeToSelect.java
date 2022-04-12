package br.com.mind5.business.storeTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StorextarchInfo, StorextarchInfo> {
	
	public StorextarchVisiMergeToSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option, StorextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StorextarchInfo>> getVisitorClassHook() {
		return StorextarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextarchInfo> toActionClassHook(List<StorextarchInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<StorextarchInfo> mergeHook(List<StorextarchInfo> baseInfos, List<StorextarchInfo> selectedInfos) {	
		return StorextarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
