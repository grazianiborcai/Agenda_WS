package br.com.mind5.business.scheduleAuthorization.model.action;

import java.util.List;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleAuthorization.info.SchedauthMerger;
import br.com.mind5.business.storeSearch.info.SotarchCopier;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.RootSotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedauthMergeSotarch extends ActionVisitorTemplateMergeV2<SchedauthInfo, SotarchInfo> {
	
	public VisiSchedauthMergeSotarch(DeciTreeOption<SchedauthInfo> option) {
		super(option, SotarchInfo.class);
	}
	
	
	
	protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return RootSotarchSelect.class;
	}
	
	
	
	protected List<SotarchInfo> toActionClassHook(List<SchedauthInfo> baseInfos) {
		return SotarchCopier.copyFromSchedauth(baseInfos);	
	}
	
	
	
	@Override protected List<SchedauthInfo> mergeHook(List<SchedauthInfo> baseInfos, List<SotarchInfo> selectedInfos) {	
		return SchedauthMerger.mergeWithSotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
