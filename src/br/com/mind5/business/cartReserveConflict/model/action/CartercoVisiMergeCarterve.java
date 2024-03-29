package br.com.mind5.business.cartReserveConflict.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.CarterveRootSelect;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartercoVisiMergeCarterve extends ActionVisitorTemplateMerge<CartercoInfo, CarterveInfo> {
	
	public CartercoVisiMergeCarterve(DeciTreeOption<CartercoInfo> option) {
		super(option, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return CarterveRootSelect.class;
	}
	
	
	
	@Override protected List<CartercoInfo> mergeHook(List<CartercoInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return CartercoMerger.mergeWithCarterve(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
