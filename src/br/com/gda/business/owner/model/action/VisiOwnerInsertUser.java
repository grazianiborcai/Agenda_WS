package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.user.info.UserCopier;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserInsert;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerInsertUser extends ActionVisitorTemplateAction<OwnerInfo, UserInfo> {
	public VisiOwnerInsertUser(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<UserInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.add(UserCopier.copyFromOwner(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserInsert(option).toAction();
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<UserInfo> results) {
		InfoWritterFactory<OwnerInfo> merger = new OwnerMerger();		
		return merger.merge(results, baseInfos);
	}
}
