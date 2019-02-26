package br.com.gda.servlet.authentication;

import java.util.List;

import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.decisionTree.RootJwtokenParse;

final class AuthJwtParse extends DeciTreeOneCallTemplate<JwtokenInfo> {

	public AuthJwtParse(JwtokenInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	public AuthJwtParse(List<JwtokenInfo> recordInfos) {
		super(recordInfos);
	}
	
	
	
	@Override protected DeciTree<JwtokenInfo> getTreeHook(DeciTreeOption<JwtokenInfo> optionTree) {
		return new RootJwtokenParse(optionTree);
	}
}
