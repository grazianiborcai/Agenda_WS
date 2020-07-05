package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonDelete;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

final class VisiUserPersonDelete extends ActionVisitorTemplateActionV2<UserInfo, PersonInfo> {
	
	public VisiUserPersonDelete(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonDelete.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return PersonCopier.copyFromUserKey(recordInfos);
	}
}
