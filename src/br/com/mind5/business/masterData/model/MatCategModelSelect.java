package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
