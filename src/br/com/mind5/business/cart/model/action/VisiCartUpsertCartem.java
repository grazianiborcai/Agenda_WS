package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cartItem.info.CartemCopier;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.RootCartemUpsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartUpsertCartem extends ActionVisitorTemplateActionV2<CartInfo, CartemInfo> {
	
	public VisiCartUpsertCartem(DeciTreeOption<CartInfo> option) {
		super(option, CartInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return RootCartemUpsert.class;
	}
	
	
	
	@Override protected List<CartemInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return CartemCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<CartemInfo> results) {
		return baseInfos;
	}
}
