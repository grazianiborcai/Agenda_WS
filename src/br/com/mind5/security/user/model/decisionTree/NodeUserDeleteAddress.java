package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserDeleteAddress;
import br.com.mind5.security.user.model.action.LazyUserEnforceAddressKey;
import br.com.mind5.security.user.model.action.StdUserMergeAddress;
import br.com.mind5.security.user.model.action.StdUserSuccess;
import br.com.mind5.security.user.model.checker.UserCheckAddressExist;

public final class NodeUserDeleteAddress extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserDeleteAddress(DeciTreeOption<UserInfo> option) {
		super(option);
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
		checker = new UserCheckAddressExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergeAddress = new StdUserMergeAddress(option);
		ActionLazy<UserInfo> enforceAddressKey = new LazyUserEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteAddress = new LazyUserDeleteAddress(option.conn, option.schemaName);
		
		mergeAddress.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(deleteAddress);
		
		actions.add(mergeAddress);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnFailedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		actions.add(new StdUserSuccess(option));		
		return actions;
	}
}
