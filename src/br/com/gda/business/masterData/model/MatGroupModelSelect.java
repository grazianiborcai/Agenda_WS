package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatGroupSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
