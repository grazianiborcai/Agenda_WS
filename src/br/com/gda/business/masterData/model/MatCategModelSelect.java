package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatCategModelSelect extends ModelTemplate<MatCategInfo> {

	public MatCategModelSelect(MatCategInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatCategInfo> getDecisionTreeHook(DeciTreeOption<MatCategInfo> option) {
		return new RootMatCategSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
