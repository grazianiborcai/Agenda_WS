package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreMerger;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.decisionTree.DisegyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreVisiMergeDisegy extends ActionVisitorTemplateMerge<DisoreInfo, DisegyInfo> {
	
	public DisoreVisiMergeDisegy(DeciTreeOption<DisoreInfo> option) {
		super(option, DisegyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisegyInfo>> getTreeClassHook() {
		return DisegyRootSelect.class;
	}
	
	
	
	@Override protected List<DisoreInfo> mergeHook(List<DisoreInfo> baseInfos, List<DisegyInfo> selectedInfos) {	
		return DisoreMerger.mergeWithDisegy(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
