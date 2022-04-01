package br.com.mind5.business.cartCounter.model.action;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartCounter.info.CartouMerger;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.CartemRootSearchUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartouVisiMergeCartem extends ActionVisitorTemplateMerge<CartouInfo, CartemInfo> {
	
	public CartouVisiMergeCartem(DeciTreeOption<CartouInfo> option) {
		super(option, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return CartemRootSearchUser.class;
	}
	
	
	
	@Override protected List<CartouInfo> mergeHook(List<CartouInfo> baseInfos, List<CartemInfo> selectedInfos) {	
		return CartouMerger.mergeWithCartem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
