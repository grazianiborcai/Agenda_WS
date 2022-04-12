package br.com.mind5.business.storeTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.info.StorextaultMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextaultVisiMergeToSelect extends ActionVisitorTemplateMerge<StorextaultInfo, StorextaultInfo> {
	
	public StorextaultVisiMergeToSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option, StorextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StorextaultInfo>> getVisitorClassHook() {
		return StorextaultVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextaultInfo> toActionClassHook(List<StorextaultInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<StorextaultInfo> mergeHook(List<StorextaultInfo> baseInfos, List<StorextaultInfo> selectedInfos) {	
		return StorextaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
