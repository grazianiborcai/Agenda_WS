package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.CartCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCartCategSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartCategModelSelect extends ModelTemplate<CartCategInfo> {

	public CartCategModelSelect(CartCategInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CartCategInfo> getDecisionTreeHook(DeciTreeOption<CartCategInfo> option) {
		return new RootCartCategSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
