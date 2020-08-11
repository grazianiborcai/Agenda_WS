package br.com.mind5.security.userPasswordSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchMerger;

final class VisiUpswdarchMergeToSelect extends ActionVisitorTemplateMergeV2<UpswdarchInfo, UpswdarchInfo> {
	
	public VisiUpswdarchMergeToSelect(DeciTreeOption<UpswdarchInfo> option) {
		super(option, UpswdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<UpswdarchInfo>> getActionClassHook() {
		return StdUpswdarchDaoSelect.class;
	}
	
	
	
	@Override protected List<UpswdarchInfo> mergeHook(List<UpswdarchInfo> baseInfos, List<UpswdarchInfo> selectedInfos) {	
		return UpswdarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
