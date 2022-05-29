package br.com.mind5.security.jwtToken.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.JwtokenNodeValidateL2;

public final class JwtokenVisiNodeValidateL2 extends ActionVisitorTemplateAction<JwtokenInfo, JwtokenInfo> {

	public JwtokenVisiNodeValidateL2(DeciTreeOption<JwtokenInfo> option) {
		super(option, JwtokenInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return JwtokenNodeValidateL2.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toBaseClassHook(List<JwtokenInfo> baseInfos, List<JwtokenInfo> results) {
		return results;
	}
}
