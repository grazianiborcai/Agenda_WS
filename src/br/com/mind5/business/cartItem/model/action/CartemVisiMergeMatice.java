package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.model.decisionTree.RootMaticeSelectByWeekday;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemVisiMergeMatice extends ActionVisitorTemplateMerge<CartemInfo, MaticeInfo> {
	
	public CartemVisiMergeMatice(DeciTreeOption<CartemInfo> option) {
		super(option, MaticeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MaticeInfo>> getTreeClassHook() {
		return RootMaticeSelectByWeekday.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> baseInfos, List<MaticeInfo> selectedInfos) {	
		return CartemMerger.mergeWithMatice(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
