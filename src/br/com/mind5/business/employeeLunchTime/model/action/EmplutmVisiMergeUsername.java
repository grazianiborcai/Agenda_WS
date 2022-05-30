package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmMerger;
import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class EmplutmVisiMergeUsername extends ActionVisitorTemplateMerge<EmplutmInfo, UsernameInfo> {
	
	public EmplutmVisiMergeUsername(DeciTreeOption<EmplutmInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<EmplutmInfo> mergeHook(List<EmplutmInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return EmplutmMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
