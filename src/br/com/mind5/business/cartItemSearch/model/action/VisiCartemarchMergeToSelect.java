package br.com.mind5.business.cartItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.info.CartemarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemarchMergeToSelect extends ActionVisitorTemplateMerge<CartemarchInfo, CartemarchInfo> {
	
	public VisiCartemarchMergeToSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option, CartemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CartemarchInfo>> getActionClassHook() {
		return StdCartemarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CartemarchInfo> mergeHook(List<CartemarchInfo> baseInfos, List<CartemarchInfo> selectedInfos) {	
		return CartemarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
