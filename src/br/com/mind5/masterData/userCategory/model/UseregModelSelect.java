package br.com.mind5.masterData.userCategory.model;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.decisionTree.UseregRootCategSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class UseregModelSelect extends ModelTemplate<UseregInfo> {

	public UseregModelSelect(UseregInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<UseregInfo> getDecisionTreeHook(DeciTreeOption<UseregInfo> option) {
		return new UseregRootCategSelect(option);
	}
}
