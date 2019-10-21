package br.com.mind5.business.material.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatModelInsert extends ModelTemplate<MatInfo> {

	public MatModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatInfo> getDecisionTreeHook(DeciTreeOption<MatInfo> option) {
		return new RootMatInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
