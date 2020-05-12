package br.com.mind5.message.emailBody.model.action;

import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.info.EmabodyMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmabodyMergeToSelect extends ActionVisitorTemplateMergeV2<EmabodyInfo, EmabodyInfo> {
	
	public VisiEmabodyMergeToSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option, EmabodyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmabodyInfo>> getActionClassHook() {
		return StdEmabodyDaoSelect.class;
	}
	
	
	
	@Override protected List<EmabodyInfo> mergeHook(List<EmabodyInfo> baseInfos, List<EmabodyInfo> selectedInfos) {	
		return EmabodyMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
