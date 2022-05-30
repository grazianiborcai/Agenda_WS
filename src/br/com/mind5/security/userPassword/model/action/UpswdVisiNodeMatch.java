package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.UpswdNodeMatch;

public final class UpswdVisiNodeMatch extends ActionVisitorTemplateAction<UpswdInfo, UpswdInfo> {

	public UpswdVisiNodeMatch(DeciTreeOption<UpswdInfo> option) {
		super(option, UpswdInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UpswdInfo>> getTreeClassHook() {
		return UpswdNodeMatch.class;
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<UpswdInfo> results) {
		return results;
	}
}
