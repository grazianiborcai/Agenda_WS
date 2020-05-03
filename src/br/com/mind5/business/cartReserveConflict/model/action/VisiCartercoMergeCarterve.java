package br.com.mind5.business.cartReserveConflict.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartercoMergeCarterve extends ActionVisitorTemplateMergeV2<CartercoInfo, CarterveInfo> {
	
	public VisiCartercoMergeCarterve(DeciTreeOption<CartercoInfo> option) {
		super(option, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return RootCarterveSelect.class;
	}
	
	
	
	@Override protected List<CartercoInfo> mergeHook(List<CartercoInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return CartercoMerger.mergeWithCarterve(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
