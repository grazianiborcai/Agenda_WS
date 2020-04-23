package br.com.mind5.business.employee.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonDelete;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpDeletePerson extends ActionVisitorTemplateActionV2<EmpInfo, PersonInfo> {
	public VisiEmpDeletePerson(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonDelete.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();	//TODO: mover para Copier
		
		for (EmpInfo eachRecord : recordInfos) {
			results.add(PersonInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
}
