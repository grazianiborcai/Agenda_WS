package br.com.mind5.security.userAuthentication.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.model.decisionTree.RootUauthUpswd;

public final class UauthModelUpswd extends ModelTemplate<UauthInfo> {
	
	public UauthModelUpswd(UauthInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<UauthInfo> getDecisionTreeHook(DeciTreeOption<UauthInfo> option) {
		return new RootUauthUpswd(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
