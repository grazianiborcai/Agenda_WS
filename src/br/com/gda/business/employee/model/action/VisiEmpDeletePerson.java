package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmpDeletePerson extends ActionVisitorTemplateAction<EmpInfo, PersonInfo> {
	public VisiEmpDeletePerson(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (EmpInfo eachRecord : recordInfos) {
			results.add(PersonInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonDelete(option).toAction();
	}
}
