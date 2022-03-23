package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.CartNodeDeleteL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartVisiNodeDeleteL1 extends ActionVisitorTemplateAction<CartInfo, CartInfo> {

	public CartVisiNodeDeleteL1(DeciTreeOption<CartInfo> option) {
		super(option, CartInfo.class, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartInfo>> getTreeClassHook() {
		return CartNodeDeleteL1.class;
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<CartInfo> results) {
		return results;
	}
}
