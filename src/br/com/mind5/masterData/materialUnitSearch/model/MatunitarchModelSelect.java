package br.com.mind5.masterData.materialUnitSearch.model;

import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.masterData.materialUnitSearch.model.decisionTree.RootMatunitarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatunitarchModelSelect extends ModelTemplate<MatunitarchInfo> {

	public MatunitarchModelSelect(MatunitarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatunitarchInfo> getDecisionTreeHook(DeciTreeOption<MatunitarchInfo> option) {
		return new RootMatunitarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
