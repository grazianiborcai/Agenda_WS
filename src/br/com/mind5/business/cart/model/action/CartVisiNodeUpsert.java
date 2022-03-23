package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.CartNodeUpsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartVisiNodeUpsert extends ActionVisitorTemplateAction<CartInfo, CartInfo> {

	public CartVisiNodeUpsert(DeciTreeOption<CartInfo> option) {
		super(option, CartInfo.class, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartInfo>> getTreeClassHook() {
		return CartNodeUpsert.class;
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<CartInfo> results) {
		return results;
	}
}
