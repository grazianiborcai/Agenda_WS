package br.com.mind5.security.tokenAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class TauthVisiMergeUsername extends ActionVisitorTemplateMerge<TauthInfo, UsernameInfo> {
	
	public TauthVisiMergeUsername(DeciTreeOption<TauthInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<TauthInfo> mergeHook(List<TauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return TauthMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
