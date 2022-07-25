package br.com.mind5.discount.discountStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapMerger;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.decisionTree.DisegyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorapVisiMergeDisegy extends ActionVisitorTemplateMerge<DisorapInfo, DisegyInfo> {
	
	public DisorapVisiMergeDisegy(DeciTreeOption<DisorapInfo> option) {
		super(option, DisegyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisegyInfo>> getTreeClassHook() {
		return DisegyRootSelect.class;
	}
	
	
	
	@Override protected List<DisorapInfo> mergeHook(List<DisorapInfo> baseInfos, List<DisegyInfo> selectedInfos) {	
		return DisorapMerger.mergeWithDisegy(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
