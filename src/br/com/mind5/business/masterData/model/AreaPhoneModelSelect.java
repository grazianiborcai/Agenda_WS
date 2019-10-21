package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootAreaPhoneSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AreaPhoneModelSelect extends ModelTemplate<AreaPhoneInfo> {

	public AreaPhoneModelSelect(AreaPhoneInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<AreaPhoneInfo> getDecisionTreeHook(DeciTreeOption<AreaPhoneInfo> option) {
		return new RootAreaPhoneSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
