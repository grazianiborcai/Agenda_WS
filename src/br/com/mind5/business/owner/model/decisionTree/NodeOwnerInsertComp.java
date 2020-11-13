package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerDaoUpdate;
import br.com.mind5.business.owner.model.action.LazyOwnerCompInsert;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceCompKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOwnerInsertComp extends DeciTreeTemplateWrite<OwnerInfo> {
	
	public NodeOwnerInsertComp(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceCompKey = new StdOwnerEnforceCompKey(option);
		ActionLazy<OwnerInfo> insertComp = new LazyOwnerCompInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> updateOwner = new LazyOwnerDaoUpdate(option.conn, option.schemaName);
		
		enforceCompKey.addPostAction(insertComp);
		insertComp.addPostAction(updateOwner);
		
		actions.add(enforceCompKey);	
		return actions;
	}
}
