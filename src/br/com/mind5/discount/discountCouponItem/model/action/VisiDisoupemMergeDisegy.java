package br.com.mind5.discount.discountCouponItem.model.action;

import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.info.DisoupemMerger;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.decisionTree.RootDisegySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoupemMergeDisegy extends ActionVisitorTemplateMerge<DisoupemInfo, DisegyInfo> {
	
	public VisiDisoupemMergeDisegy(DeciTreeOption<DisoupemInfo> option) {
		super(option, DisegyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisegyInfo>> getTreeClassHook() {
		return RootDisegySelect.class;
	}
	
	
	
	@Override protected List<DisoupemInfo> mergeHook(List<DisoupemInfo> baseInfos, List<DisegyInfo> selectedInfos) {	
		return DisoupemMerger.mergeWithDisegy(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
