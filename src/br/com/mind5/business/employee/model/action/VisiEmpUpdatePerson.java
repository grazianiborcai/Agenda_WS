package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonUpdate;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpUpdatePerson extends ActionVisitorTemplateActionV2<EmpInfo, PersonInfo> {
	
	public VisiEmpUpdatePerson(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonUpdate.class;
	}
	
	

	@Override protected List<PersonInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return PersonCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<PersonInfo> results) {
		return EmpMerger.mergeWithPerson(baseInfos, results);
	}
}
