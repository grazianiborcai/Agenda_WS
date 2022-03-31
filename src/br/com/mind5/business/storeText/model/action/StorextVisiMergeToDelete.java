package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiMergeToDelete extends ActionVisitorTemplateMerge<StorextInfo, StorextInfo> {
	
	public StorextVisiMergeToDelete(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StorextInfo>> getVisitorClassHook() {
		return StorextVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StorextMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
