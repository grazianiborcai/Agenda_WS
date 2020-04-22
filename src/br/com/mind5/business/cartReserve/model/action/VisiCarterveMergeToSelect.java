package br.com.mind5.business.cartReserve.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.info.CarterveMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCarterveMergeToSelect extends ActionVisitorTemplateMergeV2<CarterveInfo, CarterveInfo> {
	
	public VisiCarterveMergeToSelect(DeciTreeOption<CarterveInfo> option) {
		super(option, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CarterveInfo>> getActionClassHook() {
		return StdCarterveDaoSelect.class;
	}
	
	
	
	@Override protected List<CarterveInfo> mergeHook(List<CarterveInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return CarterveMerger.mergeToSelect(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
