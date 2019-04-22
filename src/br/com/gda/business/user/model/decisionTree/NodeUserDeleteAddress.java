package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserDeleteAddress;
import br.com.gda.business.user.model.action.LazyUserEnforceAddressKey;
import br.com.gda.business.user.model.action.StdUserMergeAddress;
import br.com.gda.business.user.model.action.StdUserSuccess;
import br.com.gda.business.user.model.checker.UserCheckAddressExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

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
