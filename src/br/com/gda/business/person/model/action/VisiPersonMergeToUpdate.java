package br.com.gda.business.person.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiPersonMergeToUpdate extends ActionVisitorTemplateMergeV2<PersonInfo, PersonInfo> {
	
	public VisiPersonMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PersonInfo>> getActionClassHook() {
		return StdPersonSelect.class;
	}
	
	
	
	@Override protected List<PersonInfo> mergeHook(List<PersonInfo> recordInfos, List<PersonInfo> selectedInfos) {	
		return PersonMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
