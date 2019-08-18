package br.com.gda.business.phone.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneInsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

//TODO: Classe para teste. Eliminar

public final class PhoneModelInsert extends ModelTemplate<PhoneInfo> {

	public PhoneModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PhoneInfo.class);
	}
	
	
	
	@Override protected DeciTree<PhoneInfo> getDecisionTreeHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
