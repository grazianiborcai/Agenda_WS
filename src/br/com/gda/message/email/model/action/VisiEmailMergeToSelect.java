package br.com.gda.message.email.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.info.EmailMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmailMergeToSelect extends ActionVisitorTemplateMergeV2<EmailInfo, EmailInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
