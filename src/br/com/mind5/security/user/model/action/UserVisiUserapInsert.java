package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.decisionTree.UserapRootInsert;

public final class UserVisiUserapInsert extends ActionVisitorTemplateAction<UserInfo, UserapInfo> {
	
	public UserVisiUserapInsert(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserapInfo>> getTreeClassHook() {
		return UserapRootInsert.class;
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UserapInfo> results) {
		return UserMerger.mergeWithUserap(baseInfos, results);
	}
}
