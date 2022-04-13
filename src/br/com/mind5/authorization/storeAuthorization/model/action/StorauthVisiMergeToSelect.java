package br.com.mind5.authorization.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.info.StorauthMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorauthVisiMergeToSelect extends ActionVisitorTemplateMerge<StorauthInfo, StorauthInfo> {
	
	public StorauthVisiMergeToSelect(DeciTreeOption<StorauthInfo> option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StorauthInfo>> getVisitorClassHook() {
		return StorauthVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StorauthInfo> mergeHook(List<StorauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {	
		return StorauthMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
