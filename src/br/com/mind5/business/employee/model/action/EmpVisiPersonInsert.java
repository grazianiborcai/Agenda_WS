package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootInsertEmp;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiPersonInsert extends ActionVisitorTemplateAction<EmpInfo, PersonInfo> {
	
	public EmpVisiPersonInsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootInsertEmp.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<EmpInfo> baseInfos) {
		return PersonCopier.copyFromEmp(baseInfos);
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<PersonInfo> results) {
		return EmpMerger.mergeWithPerson(baseInfos, results);
	}
}
