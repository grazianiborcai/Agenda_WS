package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.JwtokenRootGenerate;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class VisiUpswdJwtokenGenerate extends ActionVisitorTemplateAction<UpswdInfo, JwtokenInfo> {
	
	public VisiUpswdJwtokenGenerate(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return JwtokenRootGenerate.class;
	}
	
	
	
	protected List<JwtokenInfo> toActionClassHook(List<UpswdInfo> recordInfos) {
		return JwtokenInfo.copyFrom(recordInfos);	
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<JwtokenInfo> results) {
		return baseInfos;
	}
}
