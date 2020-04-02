package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

final class VisiUserDeletePerson extends ActionVisitorTemplateAction<UserInfo, PersonInfo> {
	public VisiUserDeletePerson(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return PersonCopier.copyFromUserKey(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<PersonInfo> getActionHook(DeciTreeOption<PersonInfo> option) {
		return new RootPersonDelete(option).toAction();
	}
}
