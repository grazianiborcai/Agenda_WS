package br.com.mind5.security.userPasswordSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchMerger;

public final class UpswdarchVisiMergeToSelect extends ActionVisitorTemplateMerge<UpswdarchInfo, UpswdarchInfo> {
	
	public UpswdarchVisiMergeToSelect(DeciTreeOption<UpswdarchInfo> option) {
		super(option, UpswdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<UpswdarchInfo>> getVisitorClassHook() {
		return UpswdarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<UpswdarchInfo> mergeHook(List<UpswdarchInfo> baseInfos, List<UpswdarchInfo> selectedInfos) {	
		return UpswdarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
