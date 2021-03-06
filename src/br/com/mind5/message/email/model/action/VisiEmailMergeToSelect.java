package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmailMergeToSelect extends ActionVisitorTemplateMerge<EmailInfo, EmailInfo> {
	
	public VisiEmailMergeToSelect(DeciTreeOption<EmailInfo> option) {
		super(option, EmailInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmailInfo>> getActionClassHook() {
		return StdEmailDaoSelect.class;
	}
	
	
	
	@Override protected List<EmailInfo> mergeHook(List<EmailInfo> baseInfos, List<EmailInfo> selectedInfos) {	
		return EmailMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
