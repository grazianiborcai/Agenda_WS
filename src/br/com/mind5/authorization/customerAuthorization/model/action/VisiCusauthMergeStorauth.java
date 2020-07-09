package br.com.mind5.authorization.customerAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.authorization.customerAuthorization.info.CusauthMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.decisionTree.RootStorauthSelect;

final class VisiCusauthMergeStorauth extends ActionVisitorTemplateMergeV2<CusauthInfo, StorauthInfo> {
	
	public VisiCusauthMergeStorauth(DeciTreeOption<CusauthInfo> option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorauthInfo>> getTreeClassHook() {
		return RootStorauthSelect.class;
	}
	
	
	
	@Override protected List<CusauthInfo> mergeHook(List<CusauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {	
		return CusauthMerger.mergeWithStorauth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
