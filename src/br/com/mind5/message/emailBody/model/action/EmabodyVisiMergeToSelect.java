package br.com.mind5.message.emailBody.model.action;

import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.info.EmabodyMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmabodyVisiMergeToSelect extends ActionVisitorTemplateMerge<EmabodyInfo, EmabodyInfo> {
	
	public EmabodyVisiMergeToSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option, EmabodyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmabodyInfo>> getVisitorClassHook() {
		return EmabodyVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmabodyInfo> mergeHook(List<EmabodyInfo> baseInfos, List<EmabodyInfo> selectedInfos) {	
		return EmabodyMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
