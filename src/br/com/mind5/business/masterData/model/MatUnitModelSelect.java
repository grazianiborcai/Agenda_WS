package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
