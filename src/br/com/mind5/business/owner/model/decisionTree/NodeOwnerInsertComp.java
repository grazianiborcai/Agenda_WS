package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerInsertComp;
import br.com.mind5.business.owner.model.action.LazyOwnerUpdate;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceCompKey;
import br.com.mind5.business.owner.model.checker.OwnerCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerInsertComp extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerInsertComp(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;

		checker = new OwnerCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> enforceCompKey = new StdOwnerEnforceCompKey(option);
		ActionLazyV1<OwnerInfo> insertComp = new LazyOwnerInsertComp(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> updateOwner = new LazyOwnerUpdate(option.conn, option.schemaName);
		
		enforceCompKey.addPostAction(insertComp);
		insertComp.addPostAction(updateOwner);
		
		actions.add(enforceCompKey);	
		return actions;
	}
}
