package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartVisiOrderInsert extends ActionVisitorTemplateAction<CartInfo, OrderInfo> {
	
	public CartVisiOrderInsert(DeciTreeOption<CartInfo> option) {
		super(option, CartInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderRootInsert.class;
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return OrderCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<OrderInfo> results) {
		return CartMerger.mergeWithOrder(baseInfos, results);
	}
}
