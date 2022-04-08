package br.com.mind5.business.materialStore.model;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreModelSelect extends ModelTemplate<MatoreInfo> {

	public MatoreModelSelect(MatoreInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatoreInfo> getDecisionTreeHook(DeciTreeOption<MatoreInfo> option) {
		return new MatoreRootSelect(option);
	}
}
