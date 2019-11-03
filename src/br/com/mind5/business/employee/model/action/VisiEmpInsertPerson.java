package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonInsertEmp;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpInsertPerson extends ActionVisitorTemplateAction<EmpInfo, PersonInfo> {
	public VisiEmpInsertPerson(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return PersonCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonInsertEmp(option).toAction();
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<PersonInfo> results) {
		return EmpMerger.mergeWithPerson(results, baseInfos);
	}
}
