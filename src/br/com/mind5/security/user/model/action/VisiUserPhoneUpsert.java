package br.com.mind5.security.user.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

final class VisiUserPhoneUpsert extends ActionVisitorTemplateAction<UserInfo, PhoneInfo> {
	
	public VisiUserPhoneUpsert(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootUpsertdel.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<UserInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (UserInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
}
