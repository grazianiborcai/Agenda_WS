package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.person.info.PersonCopier;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonInsert;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerInsertPerson extends ActionVisitorTemplateAction<OwnerInfo, PersonInfo> {
	public VisiOwnerInsertPerson(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromOwner(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonInsert(option).toAction();
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory<OwnerInfo> merger = new OwnerMerger();		
		return merger.merge(results, baseInfos);
	}
}
