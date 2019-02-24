package br.com.gda.servlet.authUser;

import java.util.List;

import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.decisionTree.RootJwtokenGenerate;

final class AuthJwtGenerate extends DeciTreeOneCallTemplate<JwtokenInfo> {

	public AuthJwtGenerate(JwtokenInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	public AuthJwtGenerate(List<JwtokenInfo> recordInfos) {
		super(recordInfos);
	}
	
	
	
	@Override protected DeciTree<JwtokenInfo> getTreeHook(DeciTreeOption<JwtokenInfo> optionTree) {
		return new RootJwtokenGenerate(optionTree);
	}
}
