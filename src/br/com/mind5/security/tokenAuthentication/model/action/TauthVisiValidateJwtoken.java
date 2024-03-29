package br.com.mind5.security.tokenAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.JwtokenRootValidate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;

public final class TauthVisiValidateJwtoken extends ActionVisitorTemplateAction<TauthInfo, JwtokenInfo> {
	
	public TauthVisiValidateJwtoken(DeciTreeOption<TauthInfo> option) {
		super(option, TauthInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return JwtokenRootValidate.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected List<TauthInfo> toBaseClassHook(List<TauthInfo> baseInfos, List<JwtokenInfo> results) {
		return TauthMerger.mergeWithJwtoken(baseInfos, results);
	}
}
