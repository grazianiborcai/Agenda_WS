package br.com.mind5.business.company.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompModelUpdate extends ModelTemplate<CompInfo> {

	public CompModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CompInfo.class);
	}
	
	
	
	@Override protected DeciTree<CompInfo> getDecisionTreeHook(DeciTreeOption<CompInfo> option) {
		return new RootCompUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
