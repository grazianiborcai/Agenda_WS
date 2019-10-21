package br.com.mind5.business.company.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompModelInsert extends ModelTemplate<CompInfo> {

	public CompModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CompInfo.class);
	}
	
	
	
	@Override protected DeciTree<CompInfo> getDecisionTreeHook(DeciTreeOption<CompInfo> option) {
		return new RootCompInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
