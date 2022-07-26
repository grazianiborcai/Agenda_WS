package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailMerger;
import br.com.mind5.message.emailBody.info.EmabodyCopier;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.model.decisionTree.RootEmabodySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmailVisiMergeEmabody extends ActionVisitorTemplateMerge<EmailInfo, EmabodyInfo> {
	
	public EmailVisiMergeEmabody(DeciTreeOption<EmailInfo> option) {
		super(option, EmabodyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmabodyInfo>> getTreeClassHook() {
		return RootEmabodySelect.class;
	}
	
	
	
	@Override protected List<EmabodyInfo> toActionClassHook(List<EmailInfo> recordInfos) {
		return EmabodyCopier.copyFromEmail(recordInfos);
	}
	
	
	
	@Override protected List<EmailInfo> mergeHook(List<EmailInfo> baseInfos, List<EmabodyInfo> selectedInfos) {	
		return EmailMerger.mergeWithEmabody(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
