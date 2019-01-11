package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonUpdate;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerUpdatePerson extends ActionVisitorTemplateAction<OwnerInfo, PersonInfo> {
	public VisiOwnerUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, PersonInfo.class);
	}
	
	
	//TODO: isso parece que nao vai funcionar. Testar
	@Override protected List<PersonInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.add(PersonInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonUpdate(option).toAction();
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory<OwnerInfo> merger = new OwnerMerger();		
		return merger.merge(results, baseInfos);
	}
}
