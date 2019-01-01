package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonInsert;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusMerger;

final class VisiPayCusInsertPerson extends ActionVisitorTemplateAction<PayCusInfo, PersonInfo> {
	public VisiPayCusInsertPerson(Connection conn, String schemaName) {
		super(conn, schemaName, PayCusInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<PayCusInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (PayCusInfo eachRecord : recordInfos) {
			results.add(PersonInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonInsert(option).toAction();
	}
	
	
	
	@Override protected List<PayCusInfo> toBaseClassHook(List<PayCusInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory<PayCusInfo> merger = new PayCusMerger();		
		return merger.merge(results, baseInfos);
	}
}
