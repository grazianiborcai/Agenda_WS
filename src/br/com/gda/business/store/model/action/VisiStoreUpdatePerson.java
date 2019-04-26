package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonCopier;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonUpdate;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreUpdatePerson extends ActionVisitorTemplateAction<StoreInfo, PersonInfo> {
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
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonUpdate(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory_<StoreInfo> merger = new StoreMerger();		
		return merger.merge(results, baseInfos);
	}
}
