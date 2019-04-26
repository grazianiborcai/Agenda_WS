package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.person.info.PersonCopier;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCusInsertPerson extends ActionVisitorTemplateAction<CusInfo, PersonInfo> {
	public VisiCusInsertPerson(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<CusInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (CusInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromCus(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonInsert(option).toAction();
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<PersonInfo> results) {
		return CusMerger.mergeWithPerson(results, baseInfos);
	}
}
