package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerInsertComp;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceCompKey;
import br.com.mind5.business.owner.model.checker.OwnerCheckHasComp;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerInsertComp extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerInsertComp(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		final boolean HAS_COMPANY = true;
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_COMPANY;		
		checker = new OwnerCheckHasComp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceCompKey = new StdOwnerEnforceCompKey(option);
		ActionLazy<OwnerInfo> insertComp = new LazyOwnerInsertComp(option.conn, option.schemaName);
		
		enforceCompKey.addPostAction(insertComp);
		
		actions.add(enforceCompKey);	
		return actions;
	}
}
