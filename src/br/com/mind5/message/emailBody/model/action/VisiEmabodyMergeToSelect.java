package br.com.mind5.message.emailBody.model.action;

import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.info.EmabodyMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmabodyMergeToSelect extends ActionVisitorTemplateMerge<EmabodyInfo, EmabodyInfo> {
	
	public VisiEmabodyMergeToSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option, EmabodyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmabodyInfo>> getActionClassHook() {
		return StdEmabodyDaoSelect.class;
	}
	
	
	
	@Override protected List<EmabodyInfo> mergeHook(List<EmabodyInfo> baseInfos, List<EmabodyInfo> selectedInfos) {	
		return EmabodyMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
