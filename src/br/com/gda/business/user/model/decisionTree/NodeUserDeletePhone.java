package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserDeletePhone;
import br.com.gda.business.user.model.action.LazyUserEnforcePhoneKey;
import br.com.gda.business.user.model.action.StdUserMergePhone;
import br.com.gda.business.user.model.action.StdUserSuccess;
import br.com.gda.business.user.model.checker.UserCheckPhoneExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeUserDeletePhone extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserDeletePhone(DeciTreeOption<UserInfo> option) {super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;		
		checker = new UserCheckPhoneExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergePhone = new StdUserMergePhone(option);
		ActionLazy<UserInfo> enforcePhoneKey = new LazyUserEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<UserInfo> deletePhone = new LazyUserDeletePhone(option.conn, option.schemaName);
		
		mergePhone.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(deletePhone);
		
		actions.add(mergePhone);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnFailedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		actions.add(new StdUserSuccess(option));		
		return actions;
	}
}
