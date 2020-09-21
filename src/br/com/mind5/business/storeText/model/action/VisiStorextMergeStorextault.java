package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.decisionTree.RootStorextaultSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextMergeStorextault extends ActionVisitorTemplateMergeV2<StorextInfo, StorextaultInfo> {
	
	public VisiStorextMergeStorextault(DeciTreeOption<StorextInfo> option) {
		super(option, StorextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextaultInfo>> getTreeClassHook() {
		return RootStorextaultSelect.class;
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<StorextaultInfo> selectedInfos) {	
		return StorextMerger.mergeWithStorextault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
