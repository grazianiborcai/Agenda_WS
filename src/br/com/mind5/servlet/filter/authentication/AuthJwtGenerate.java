package br.com.mind5.servlet.filter.authentication;

import java.util.List;

import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciTreeOneCallTemplate;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.RootJwtokenGenerate;

public final class AuthJwtGenerate extends DeciTreeOneCallTemplate<JwtokenInfo> {

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
