package br.com.gda.message.email.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.info.EmailMerger;
import br.com.gda.message.emailBody.info.EmabodyCopier;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.message.emailBody.model.decisionTree.RootEmabodySelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmailMergeEmabody extends ActionVisitorTemplateMergeV2<EmailInfo, EmabodyInfo> {
	
	public VisiEmailMergeEmabody(Connection conn, String schemaName) {
		super(conn, schemaName, EmabodyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmabodyInfo>> getTreeClassHook() {
		return RootEmabodySelect.class;
	}
	
	
	
	@Override protected List<EmabodyInfo> toActionClassHook(List<EmailInfo> recordInfos) {
		return EmabodyCopier.copyFromEmail(recordInfos);
	}
	
	
	
	@Override protected List<EmailInfo> mergeHook(List<EmailInfo> recordInfos, List<EmabodyInfo> selectedInfos) {	
		return EmailMerger.mergeWithEmabody(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
