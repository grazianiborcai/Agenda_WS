package br.com.mind5.discount.discountCouponItem.model.action;

import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.info.DisoupemMerger;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.model.decisionTree.DisorapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoupemVisiMergeDisorap extends ActionVisitorTemplateMerge<DisoupemInfo, DisorapInfo> {
	
	public DisoupemVisiMergeDisorap(DeciTreeOption<DisoupemInfo> option) {
		super(option, DisorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisorapInfo>> getTreeClassHook() {
		return DisorapRootSelect.class;
	}
	
	
	
	@Override protected List<DisoupemInfo> mergeHook(List<DisoupemInfo> baseInfos, List<DisorapInfo> selectedInfos) {	
		return DisoupemMerger.mergeWithDisorap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
