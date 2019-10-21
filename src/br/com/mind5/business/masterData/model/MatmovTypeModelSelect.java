package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatmovTypeSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
