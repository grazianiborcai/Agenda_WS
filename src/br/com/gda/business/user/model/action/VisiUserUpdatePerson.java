package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonCopier;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonUpdate;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserUpdatePerson extends ActionVisitorTemplateAction<UserInfo, PersonInfo> {
	public VisiUserUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<UserInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (UserInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromUser(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonUpdate(option).toAction();
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<PersonInfo> results) {
		InfoWritterFactory_<UserInfo> merger = new UserMerger();		
		return merger.merge(results, baseInfos);
	}
}
