package br.com.mind5.message.email.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmailMergeToSelect extends ActionVisitorTemplateMerge<EmailInfo, EmailInfo> {
	
	public VisiEmailMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmailInfo>> getActionClassHook() {
		return StdEmailSelect.class;
	}
	
	
	
	@Override protected List<EmailInfo> mergeHook(List<EmailInfo> recordInfos, List<EmailInfo> selectedInfos) {	
		return EmailMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
