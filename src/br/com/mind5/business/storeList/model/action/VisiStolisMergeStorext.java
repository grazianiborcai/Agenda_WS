package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.RootStorextSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolisMergeStorext extends ActionVisitorTemplateMerge<StolisInfo, StorextInfo> {
	
	public VisiStolisMergeStorext(DeciTreeOption<StolisInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return RootStorextSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StolisMerger.mergeWithStorext(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
