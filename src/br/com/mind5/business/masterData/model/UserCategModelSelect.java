package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootUserCategSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
