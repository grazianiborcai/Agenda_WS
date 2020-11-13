package br.com.mind5.security.tokenAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.RootJwtokenValidate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;

final class VisiTauthValidateJwtoken extends ActionVisitorTemplateAction<TauthInfo, JwtokenInfo> {
	
	public VisiTauthValidateJwtoken(DeciTreeOption<TauthInfo> option) {
		super(option, TauthInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return RootJwtokenValidate.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected List<TauthInfo> toBaseClassHook(List<TauthInfo> baseInfos, List<JwtokenInfo> results) {
		return TauthMerger.mergeWithJwtoken(baseInfos, results);
	}
}
