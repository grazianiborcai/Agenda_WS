package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonSnapInsert;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserSnapInsertPersonSnap extends ActionVisitorTemplateAction<UserSnapInfo, PersonSnapInfo> {
	public VisiUserSnapInsertPersonSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class, PersonSnapInfo.class);
	}
	
	
	
	@Override protected List<PersonSnapInfo> toActionClassHook(List<UserSnapInfo> recordInfos) {
		List<PersonSnapInfo> results = new ArrayList<>();
		
		for (UserSnapInfo eachRecord : recordInfos) {
			results.add(PersonSnapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PersonSnapInfo> getActionHook(DeciTreeOption<PersonSnapInfo> option) {
		return new RootPersonSnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserSnapInfo> toBaseClassHook(List<UserSnapInfo> baseInfos, List<PersonSnapInfo> results) {
		InfoWritterFactory<UserSnapInfo> merger = new UserSnapMerger();		
		return merger.merge(results, baseInfos);
	}
}
