package br.com.mind5.business.person.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapInsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonInsertPersonap extends ActionVisitorTemplateActionV1<PersonInfo, PersonapInfo> {

	public VisiPersonInsertPersonap(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class, PersonapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PersonapInfo> getActionHook(DeciTreeOption<PersonapInfo> option) {
		return new RootPersonapInsert(option).toAction();
	}
	
	
	
	protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		return PersonMerger.mergeWithPersonap(baseInfos, selectedInfos);
	}
}
