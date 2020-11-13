package br.com.mind5.business.cartReserve.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.info.CarterveMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCarterveMergeToSelect extends ActionVisitorTemplateMerge<CarterveInfo, CarterveInfo> {
	
	public VisiCarterveMergeToSelect(DeciTreeOption<CarterveInfo> option) {
		super(option, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CarterveInfo>> getActionClassHook() {
		return StdCarterveDaoSelect.class;
	}
	
	
	
	@Override protected List<CarterveInfo> mergeHook(List<CarterveInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return CarterveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
