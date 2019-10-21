package br.com.mind5.business.person.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonModelInsert extends ModelTemplate<PersonInfo> {

	public PersonModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PersonInfo.class);
	}
	
	
	
	@Override protected DeciTree<PersonInfo> getDecisionTreeHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
		