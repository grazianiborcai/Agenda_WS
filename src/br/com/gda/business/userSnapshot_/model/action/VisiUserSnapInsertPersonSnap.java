package br.com.gda.business.userSnapshot_.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonapInsert;
import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserSnapInsertPersonSnap extends ActionVisitorTemplateAction<UserSnapInfo, PersonapInfo> {
	public VisiUserSnapInsertPersonSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class, PersonapInfo.class);
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<UserSnapInfo> recordInfos) {
		List<PersonapInfo> results = new ArrayList<>();
		
		for (UserSnapInfo eachRecord : recordInfos) {
			results.add(PersonapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonapInfo> getActionHook(DeciTreeOption<PersonapInfo> option) {
		return new RootPersonapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserSnapInfo> toBaseClassHook(List<UserSnapInfo> baseInfos, List<PersonapInfo> results) {
		return baseInfos;
	}
}
