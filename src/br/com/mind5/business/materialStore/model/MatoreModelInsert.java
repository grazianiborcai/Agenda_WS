package br.com.mind5.business.materialStore.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreModelInsert extends ModelTemplate<MatoreInfo> {

	public MatoreModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatoreInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatoreInfo> getDecisionTreeHook(DeciTreeOption<MatoreInfo> option) {
		return new MatoreRootInsert(option);
	}
}
