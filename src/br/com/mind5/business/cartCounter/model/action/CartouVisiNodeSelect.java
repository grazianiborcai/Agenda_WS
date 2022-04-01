package br.com.mind5.business.cartCounter.model.action;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartCounter.model.decisionTree.CartouNodeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartouVisiNodeSelect extends ActionVisitorTemplateAction<CartouInfo, CartouInfo> {

	public CartouVisiNodeSelect(DeciTreeOption<CartouInfo> option) {
		super(option, CartouInfo.class, CartouInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartouInfo>> getTreeClassHook() {
		return CartouNodeSelect.class;
	}
	
	
	
	@Override protected List<CartouInfo> toBaseClassHook(List<CartouInfo> baseInfos, List<CartouInfo> results) {
		return results;
	}
}
