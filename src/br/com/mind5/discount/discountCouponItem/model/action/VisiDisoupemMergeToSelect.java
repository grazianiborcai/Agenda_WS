package br.com.mind5.discount.discountCouponItem.model.action;

import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.info.DisoupemMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoupemMergeToSelect extends ActionVisitorTemplateMerge<DisoupemInfo, DisoupemInfo> {
	
	public VisiDisoupemMergeToSelect(DeciTreeOption<DisoupemInfo> option) {
		super(option, DisoupemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<DisoupemInfo>> getActionClassHook() {
		return StdDisoupemDaoSelect.class;
	}
	
	
	
	@Override protected List<DisoupemInfo> mergeHook(List<DisoupemInfo> baseInfos, List<DisoupemInfo> selectedInfos) {	
		return DisoupemMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
