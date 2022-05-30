package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.UpswdRootInsert;

public final class UpswdVisiRootInsert extends ActionVisitorTemplateAction<UpswdInfo, UpswdInfo> {

	public UpswdVisiRootInsert(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UpswdInfo>> getTreeClassHook() {
		return UpswdRootInsert.class;
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<UpswdInfo> results) {
		return results;
	}
}
