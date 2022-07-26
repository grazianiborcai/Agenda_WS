package br.com.mind5.message.sysMessage.model.action;

import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SymsgVisiMergeToSelect extends ActionVisitorTemplateMerge<SymsgInfo, SymsgInfo> {
	
	public SymsgVisiMergeToSelect(DeciTreeOption<SymsgInfo> option) {
		super(option, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SymsgInfo>> getVisitorClassHook() {
		return SymsgVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> mergeHook(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return SymsgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
