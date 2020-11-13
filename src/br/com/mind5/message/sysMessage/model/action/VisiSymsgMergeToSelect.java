package br.com.mind5.message.sysMessage.model.action;

import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSymsgMergeToSelect extends ActionVisitorTemplateMerge<SymsgInfo, SymsgInfo> {
	
	public VisiSymsgMergeToSelect(DeciTreeOption<SymsgInfo> option) {
		super(option, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SymsgInfo>> getActionClassHook() {
		return StdSymsgDaoSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> mergeHook(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return SymsgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
