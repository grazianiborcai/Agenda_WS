package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.CartemRootSearchUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartVisiMergeCartem extends ActionVisitorTemplateMerge<CartInfo, CartemInfo> {
	
	public CartVisiMergeCartem(DeciTreeOption<CartInfo> option) {
		super(option, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return CartemRootSearchUser.class;
	}
	
	
	/*
	@Override protected List<CartemInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return CartemCopier.copyFromCartKey(baseInfos);	
	}*/
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> baseInfos, List<CartemInfo> selectedInfos) {	
		return CartMerger.mergeWithCartem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
