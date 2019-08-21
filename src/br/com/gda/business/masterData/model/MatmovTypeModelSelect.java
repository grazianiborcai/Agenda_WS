package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatmovTypeSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatmovTypeModelSelect extends ModelTemplate<MatmovTypeInfo> {

	public MatmovTypeModelSelect(MatmovTypeInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatmovTypeInfo> getDecisionTreeHook(DeciTreeOption<MatmovTypeInfo> option) {
		return new RootMatmovTypeSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
