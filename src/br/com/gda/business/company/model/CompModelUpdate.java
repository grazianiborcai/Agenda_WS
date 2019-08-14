package br.com.gda.business.company.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.decisionTree.RootCompUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
