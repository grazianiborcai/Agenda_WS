package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootFeeCategSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
