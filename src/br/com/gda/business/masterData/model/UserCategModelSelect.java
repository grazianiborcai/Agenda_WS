package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.UserCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootUserCategSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class UserCategModelSelect extends ModelTemplate<UserCategInfo> {

	public UserCategModelSelect(UserCategInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<UserCategInfo> getDecisionTreeHook(DeciTreeOption<UserCategInfo> option) {
		return new RootUserCategSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
