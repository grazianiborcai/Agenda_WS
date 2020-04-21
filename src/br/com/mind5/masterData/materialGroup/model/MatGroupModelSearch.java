package br.com.mind5.masterData.materialGroup.model;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.decisionTree.RootMatoupSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatGroupModelSearch extends ModelTemplate<MatoupInfo> {

	public MatGroupModelSearch(MatoupInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatoupInfo> getDecisionTreeHook(DeciTreeOption<MatoupInfo> option) {
		return new RootMatoupSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
