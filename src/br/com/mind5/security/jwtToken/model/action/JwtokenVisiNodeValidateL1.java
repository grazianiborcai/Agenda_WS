package br.com.mind5.security.jwtToken.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.JwtokenNodeValidateL1;

public final class JwtokenVisiNodeValidateL1 extends ActionVisitorTemplateAction<JwtokenInfo, JwtokenInfo> {

	public JwtokenVisiNodeValidateL1(DeciTreeOption<JwtokenInfo> option) {
		super(option, JwtokenInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return JwtokenNodeValidateL1.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toBaseClassHook(List<JwtokenInfo> baseInfos, List<JwtokenInfo> results) {
		return results;
	}
}
