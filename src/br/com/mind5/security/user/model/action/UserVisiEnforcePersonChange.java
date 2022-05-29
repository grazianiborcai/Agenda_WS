package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class UserVisiEnforcePersonChange extends ActionVisitorTemplateEnforce<UserInfo> {
	
	public UserVisiEnforcePersonChange(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		UserInfo enforcedRecord = new UserInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		enforcedRecord.codPerson = recordInfo.codPerson;
		return enforcedRecord;
	}
}
