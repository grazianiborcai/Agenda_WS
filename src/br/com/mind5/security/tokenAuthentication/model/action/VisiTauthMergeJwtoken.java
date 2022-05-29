package br.com.mind5.security.tokenAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.JwtokenRootParse;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;

final class VisiTauthMergeJwtoken extends ActionVisitorTemplateMerge<TauthInfo, JwtokenInfo> {
	
	public VisiTauthMergeJwtoken(DeciTreeOption<TauthInfo> option) {
		super(option, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return JwtokenRootParse.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected List<TauthInfo> mergeHook(List<TauthInfo> baseInfos, List<JwtokenInfo> selectedInfos) {	
		return TauthMerger.mergeWithJwtoken(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
