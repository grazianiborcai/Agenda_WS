package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatUnitModelSelect extends ModelTemplate<MatUnitInfo> {

	public MatUnitModelSelect(MatUnitInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatUnitInfo> getDecisionTreeHook(DeciTreeOption<MatUnitInfo> option) {
		return new RootMatUnitSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
