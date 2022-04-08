package br.com.mind5.business.materialStore.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreModelUpdate extends ModelTemplate<MatoreInfo> {

	public MatoreModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatoreInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatoreInfo> getDecisionTreeHook(DeciTreeOption<MatoreInfo> option) {
		return new MatoreRootUpdate(option);
	}
}
