package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonDelete;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreDeletePerson extends ActionVisitorTemplateAction<StoreInfo, PersonInfo> {
	public VisiStoreDeletePerson(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (StoreInfo eachRecord : recordInfos) {
			results.add(PersonInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonDelete(option).toAction();
	}
}
