package br.com.mind5.authorization.storePartitionAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.decisionTree.RootStorauthSelect;
import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSytotauhMergeStorauth extends ActionVisitorTemplateMergeV2<SytotauhInfo, StorauthInfo> {
	
	public VisiSytotauhMergeStorauth(DeciTreeOption<SytotauhInfo> option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorauthInfo>> getTreeClassHook() {
		return RootStorauthSelect.class;
	}
	
	
	
	@Override protected List<SytotauhInfo> mergeHook(List<SytotauhInfo> baseInfos, List<StorauthInfo> selectedInfos) {	
		return SytotauhMerger.mergeWithStorauth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
