package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
