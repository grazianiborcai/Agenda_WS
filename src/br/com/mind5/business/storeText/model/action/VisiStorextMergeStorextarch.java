package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.business.storeTextSearch.info.StorextarchCopier;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.decisionTree.RootStorextarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextMergeStorextarch extends ActionVisitorTemplateMergeV2<StorextInfo, StorextarchInfo> {
	
	public VisiStorextMergeStorextarch(DeciTreeOption<StorextInfo> option) {
		super(option, StorextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextarchInfo>> getTreeClassHook() {
		return RootStorextarchSelect.class;
	}
	
	
	
	@Override protected List<StorextarchInfo> toActionClassHook(List<StorextInfo> baseInfos) {
		return StorextarchCopier.copyFromStorext(baseInfos);	
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<StorextarchInfo> selectedInfos) {	
		return StorextMerger.mergeWithStorextarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
