package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootFeeCategSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeeCategModelSelect extends ModelTemplate<FeeCategInfo> {

	public FeeCategModelSelect(FeeCategInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FeeCategInfo> getDecisionTreeHook(DeciTreeOption<FeeCategInfo> option) {
		return new RootFeeCategSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
