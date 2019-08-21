package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCartCategSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
