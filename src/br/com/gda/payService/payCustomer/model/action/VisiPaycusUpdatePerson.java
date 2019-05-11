package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonUpdate;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusMerger;

final class VisiPaycusUpdatePerson extends ActionVisitorTemplateAction<PaycusInfo, PersonInfo> {
	public VisiPaycusUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PaycusInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<PaycusInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (PaycusInfo eachRecord : recordInfos) {
			results.add(PersonInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonUpdate(option).toAction();
	}
	
	
	
	@Override protected List<PaycusInfo> toBaseClassHook(List<PaycusInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory_<PaycusInfo> merger = new PaycusMerger();		
		return merger.merge(results, baseInfos);
	}
}
