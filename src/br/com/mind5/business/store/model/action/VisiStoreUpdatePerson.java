package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonUpdate;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreUpdatePerson extends ActionVisitorTemplateActionV1<StoreInfo, PersonInfo> {
	public VisiStoreUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (StoreInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromStore(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStdV1<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonUpdate(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<PersonInfo> results) {
		return StoreMerger.mergeWithPerson(baseInfos, results);
	}
}
