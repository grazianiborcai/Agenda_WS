package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemMergeToSelect extends ActionVisitorTemplateMerge<CartemInfo, CartemInfo> {
	
	public VisiCartemMergeToSelect(DeciTreeOption<CartemInfo> option) {
		super(option, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CartemInfo>> getActionClassHook() {
		return StdCartemDaoSelect.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> baseInfos, List<CartemInfo> selectedInfos) {	
		return CartemMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
