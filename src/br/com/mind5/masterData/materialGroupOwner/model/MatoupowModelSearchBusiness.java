package br.com.mind5.masterData.materialGroupOwner.model;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowRootSearchBusiness;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowModelSearchBusiness extends ModelTemplate<MatoupowInfo> {

	public MatoupowModelSearchBusiness(MatoupowInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatoupowInfo> getDecisionTreeHook(DeciTreeOption<MatoupowInfo> option) {
		return new MatoupowRootSearchBusiness(option);
	}
}
