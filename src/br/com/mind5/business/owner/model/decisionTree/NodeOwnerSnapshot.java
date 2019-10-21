package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerUpdate;
import br.com.mind5.business.owner.model.action.StdOwnerInsertOwnerap;
import br.com.mind5.business.owner.model.checker.OwnerCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerSnapshot extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerSnapshot(DeciTreeOption<OwnerInfo> option) {
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
		
		ActionStd<OwnerInfo> insertOwnerap = new StdOwnerInsertOwnerap(option);
		ActionLazy<OwnerInfo> update = new LazyOwnerUpdate(option.conn, option.schemaName);
		
		insertOwnerap.addPostAction(update);
		
		actions.add(insertOwnerap);
		return actions;
	}
}
