package br.com.mind5.authorization.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.info.StorauthMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorauthMergeToSelect extends ActionVisitorTemplateMerge<StorauthInfo, StorauthInfo> {
	
	public VisiStorauthMergeToSelect(DeciTreeOption<StorauthInfo> option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorauthInfo>> getActionClassHook() {
		return StdStorauthDaoSelect.class;
	}
	
	
	
	@Override protected List<StorauthInfo> mergeHook(List<StorauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {	
		return StorauthMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
