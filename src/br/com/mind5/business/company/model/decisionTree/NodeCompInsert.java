package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompEnforceCreatedBy;
import br.com.mind5.business.company.model.action.LazyCompEnforceCreatedOn;
import br.com.mind5.business.company.model.action.LazyCompInsert;
import br.com.mind5.business.company.model.action.LazyCompMergeUsername;
import br.com.mind5.business.company.model.action.StdCompEnforceLChanged;
import br.com.mind5.business.company.model.checker.CompCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCompInsert extends DeciTreeTemplateWrite<CompInfo> {
	
	public NodeCompInsert(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelCheckerV1<CompInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CompInfo> checker;
		
		checker = new CompCheckDummy();
		queue.add(checker);
			
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV1<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompInfo> enforceLChanged = new StdCompEnforceLChanged(option);
		ActionLazyV1<CompInfo> enforceLChangedBy = new LazyCompMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<CompInfo> enforceCreatedOn = new LazyCompEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<CompInfo> enforceCreatedBy = new LazyCompEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazyV1<CompInfo> insert = new LazyCompInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
