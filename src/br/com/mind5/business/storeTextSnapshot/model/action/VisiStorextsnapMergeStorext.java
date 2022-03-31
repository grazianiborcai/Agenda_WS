package br.com.mind5.business.storeTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextCopier;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextRootSearch;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextsnapMergeStorext extends ActionVisitorTemplateMerge<StorextsnapInfo, StorextInfo> {
	
	public VisiStorextsnapMergeStorext(DeciTreeOption<StorextsnapInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextRootSearch.class;
	}
	
	
	
	@Override protected List<StorextInfo> toActionClassHook(List<StorextsnapInfo> baseInfos) {
		return StorextCopier.copyFromStorextsnap(baseInfos);	
	}	
	
	
	
	@Override protected List<StorextsnapInfo> mergeHook(List<StorextsnapInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StorextsnapMerger.mergeWithStorext(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
