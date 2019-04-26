package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpMerger;
import br.com.gda.business.person.info.PersonCopier;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonUpdate;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmpUpdatePerson extends ActionVisitorTemplateAction<EmpInfo, PersonInfo> {
	public VisiEmpUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (EmpInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromEmp(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonUpdate(option).toAction();
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory_<EmpInfo> merger = new EmpMerger();		
		return merger.merge(results, baseInfos);
	}
}
