package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
