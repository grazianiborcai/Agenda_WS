package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextMergeToSelect extends ActionVisitorTemplateMerge<StorextInfo, StorextInfo> {
	
	public VisiStorextMergeToSelect(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorextInfo>> getActionClassHook() {
		return StdStorextDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextInfo> toActionClassHook(List<StorextInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StorextMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
