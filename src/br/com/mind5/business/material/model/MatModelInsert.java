package br.com.mind5.business.material.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.MatRootInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatModelInsert extends ModelTemplate<MatInfo> {

	public MatModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatInfo> getDecisionTreeHook(DeciTreeOption<MatInfo> option) {
		return new MatRootInsert(option);
	}
}
