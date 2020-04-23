package br.com.mind5.security.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.info.StorauthMerger;

final class VisiStorauthMergeToSelect extends ActionVisitorTemplateMergeV2<StorauthInfo, StorauthInfo> {
	
	public VisiStorauthMergeToSelect(DeciTreeOption<StorauthInfo> option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StorauthInfo>> getActionClassHook() {
		return StdStorauthDaoSelect.class;
	}
	
	
	
	@Override protected List<StorauthInfo> mergeHook(List<StorauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {	
		return StorauthMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
