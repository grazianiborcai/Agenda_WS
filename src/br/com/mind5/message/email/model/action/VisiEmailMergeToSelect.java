package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmailMergeToSelect extends ActionVisitorTemplateMergeV2<EmailInfo, EmailInfo> {
	
	public VisiEmailMergeToSelect(DeciTreeOption<EmailInfo> option) {
		super(option, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmailInfo>> getActionClassHook() {
		return StdEmailDaoSelect.class;
	}
	
	
	
	@Override protected List<EmailInfo> mergeHook(List<EmailInfo> recordInfos, List<EmailInfo> selectedInfos) {	
		return EmailMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
