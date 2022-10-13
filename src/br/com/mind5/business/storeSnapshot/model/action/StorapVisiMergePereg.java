package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.decisionTree.PeregRootSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiMergePereg extends ActionVisitorTemplateMerge<StorapInfo, PeregInfo> {
	
	public StorapVisiMergePereg(DeciTreeOption<StorapInfo> option) {
		super(option, PeregInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeregInfo>> getTreeClassHook() {
		return PeregRootSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<PeregInfo> selectedInfos) {	
		return StorapMerger.mergeWithPereg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}	
}
