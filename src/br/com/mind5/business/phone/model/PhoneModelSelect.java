package br.com.mind5.business.phone.model;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneModelSelect extends ModelTemplate<PhoneInfo> {

	public PhoneModelSelect(PhoneInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PhoneInfo> getDecisionTreeHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
