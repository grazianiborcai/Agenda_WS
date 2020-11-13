package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerDaoUpdate;
import br.com.mind5.business.owner.model.action.LazyOwnerCompInsert;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceCompKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOwnerInsertComp extends DeciTreeTemplateWriteV2<OwnerInfo> {
	
	public NodeOwnerInsertComp(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelCheckerV1<OwnerInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnerInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> enforceCompKey = new StdOwnerEnforceCompKey(option);
		ActionLazy<OwnerInfo> insertComp = new LazyOwnerCompInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> updateOwner = new LazyOwnerDaoUpdate(option.conn, option.schemaName);
		
		enforceCompKey.addPostAction(insertComp);
		insertComp.addPostAction(updateOwner);
		
		actions.add(enforceCompKey);	
		return actions;
	}
}
