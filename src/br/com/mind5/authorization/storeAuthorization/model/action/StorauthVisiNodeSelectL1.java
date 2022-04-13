package br.com.mind5.authorization.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.decisionTree.NodeStorauthSelectL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorauthVisiNodeSelectL1 extends ActionVisitorTemplateAction<StorauthInfo, StorauthInfo> {

	public StorauthVisiNodeSelectL1(DeciTreeOption<StorauthInfo> option) {
		super(option, StorauthInfo.class, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorauthInfo>> getTreeClassHook() {
		return NodeStorauthSelectL1.class;
	}
	
	
	
	@Override protected List<StorauthInfo> toBaseClassHook(List<StorauthInfo> baseInfos, List<StorauthInfo> results) {
		return results;
	}
}
