package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceUserCateg;
import br.com.gda.business.owner.model.action.LazyOwnerInsertUser;
import br.com.gda.business.owner.model.action.LazyOwnerInsertUserDaemon;
import br.com.gda.business.owner.model.action.StdOwnerEnforceAuthGroup;
import br.com.gda.business.owner.model.checker.OwnerCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerInsertUser extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerInsertUser(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;	
		
		checker = new OwnerCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceAuthGroup = new StdOwnerEnforceAuthGroup(option);
		ActionLazy<OwnerInfo> enforceUserCateg = new LazyOwnerEnforceUserCateg(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertUser = new LazyOwnerInsertUser(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertUserDaemon = new LazyOwnerInsertUserDaemon(option.conn, option.schemaName);
		
		enforceAuthGroup.addPostAction(enforceUserCateg);	
		enforceUserCateg.addPostAction(insertUser);	
		insertUser.addPostAction(insertUserDaemon);
		
		actions.add(enforceAuthGroup);	
		return actions;
	}
}
