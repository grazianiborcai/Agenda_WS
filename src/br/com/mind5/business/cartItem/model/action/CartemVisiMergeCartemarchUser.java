package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.CartemarchRootSelectUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemVisiMergeCartemarchUser extends ActionVisitorTemplateMerge<CartemInfo, CartemarchInfo> {
	
	public CartemVisiMergeCartemarchUser(DeciTreeOption<CartemInfo> option) {
		super(option, CartemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemarchInfo>> getTreeClassHook() {
		return CartemarchRootSelectUser.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> baseInfos, List<CartemarchInfo> selectedInfos) {	
		return CartemMerger.mergeWithCartemarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
