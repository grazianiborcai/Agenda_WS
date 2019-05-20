package br.com.gda.business.person.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonMerger;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiPersonInsertPersonap extends ActionVisitorTemplateAction<PersonInfo, PersonapInfo> {

	public VisiPersonInsertPersonap(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class, PersonapInfo.class);
	}
	
	
	
	@Override protected ActionStd<PersonapInfo> getActionHook(DeciTreeOption<PersonapInfo> option) {
		return new RootPersonapInsert(option).toAction();
	}
	
	
	
	protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PersonapInfo> results) {
		return PersonMerger.mergeWithPersonap(results, baseInfos);
	}
}
