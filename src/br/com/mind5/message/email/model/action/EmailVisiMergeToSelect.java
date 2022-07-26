package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmailVisiMergeToSelect extends ActionVisitorTemplateMerge<EmailInfo, EmailInfo> {
	
	public EmailVisiMergeToSelect(DeciTreeOption<EmailInfo> option) {
		super(option, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmailInfo>> getVisitorClassHook() {
		return EmailVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmailInfo> mergeHook(List<EmailInfo> baseInfos, List<EmailInfo> selectedInfos) {	
		return EmailMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
