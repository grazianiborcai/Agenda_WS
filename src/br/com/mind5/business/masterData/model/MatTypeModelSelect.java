package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatTypeModelSelect extends ModelTemplate<MatTypeInfo> {

	public MatTypeModelSelect(MatTypeInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatTypeInfo> getDecisionTreeHook(DeciTreeOption<MatTypeInfo> option) {
		return new RootMatTypeSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
