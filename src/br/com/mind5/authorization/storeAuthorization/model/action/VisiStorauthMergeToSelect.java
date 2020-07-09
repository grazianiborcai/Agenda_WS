package br.com.mind5.authorization.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.info.StorauthMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
