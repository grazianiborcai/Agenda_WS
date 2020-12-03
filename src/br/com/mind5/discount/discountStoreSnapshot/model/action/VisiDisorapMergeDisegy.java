package br.com.mind5.discount.discountStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapMerger;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.decisionTree.RootDisegySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisorapMergeDisegy extends ActionVisitorTemplateMerge<DisorapInfo, DisegyInfo> {
	
	public VisiDisorapMergeDisegy(DeciTreeOption<DisorapInfo> option) {
		super(option, DisegyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisegyInfo>> getTreeClassHook() {
		return RootDisegySelect.class;
	}
	
	
	
	@Override protected List<DisorapInfo> mergeHook(List<DisorapInfo> baseInfos, List<DisegyInfo> selectedInfos) {	
		return DisorapMerger.mergeWithDisegy(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
