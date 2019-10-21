package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatGroupSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatGroupModelSelect extends ModelTemplate<MatGroupInfo> {

	public MatGroupModelSelect(MatGroupInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatGroupInfo> getDecisionTreeHook(DeciTreeOption<MatGroupInfo> option) {
		return new RootMatGroupSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
