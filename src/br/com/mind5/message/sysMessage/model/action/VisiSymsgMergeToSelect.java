package br.com.mind5.message.sysMessage.model.action;

import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSymsgMergeToSelect extends ActionVisitorTemplateMergeV2<SymsgInfo, SymsgInfo> {
	
	public VisiSymsgMergeToSelect(DeciTreeOption<SymsgInfo> option) {
		super(option, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SymsgInfo>> getActionClassHook() {
		return StdSymsgDaoSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> mergeHook(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return SymsgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
