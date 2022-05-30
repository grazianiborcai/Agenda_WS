package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisNodePerson;

public final class UselisVisiNodePerson extends ActionVisitorTemplateAction<UselisInfo, UselisInfo> {

	public UselisVisiNodePerson(DeciTreeOption<UselisInfo> option) {
		super(option, UselisInfo.class, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisNodePerson.class;
	}
	
	
	
	@Override protected List<UselisInfo> toBaseClassHook(List<UselisInfo> baseInfos, List<UselisInfo> results) {
		return results;
	}
}
