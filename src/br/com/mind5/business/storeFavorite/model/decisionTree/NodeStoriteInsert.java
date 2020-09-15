package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.LazyStoriteDaoInsert;
import br.com.mind5.business.storeFavorite.model.action.LazyStoriteEnforceLChanged;
import br.com.mind5.business.storeFavorite.model.action.StdStoriteEnforceCreatedOn;
import br.com.mind5.business.storeFavorite.model.action.StdStoriteSuccess;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckExist;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStoriteInsert extends DeciTreeTemplateWriteV2<StoriteInfo> {
	
	public NodeStoriteInsert(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelCheckerV1<StoriteInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoriteCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStdV1<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoriteInfo> success = new StdStoriteSuccess(option);
		
		actions.add(success);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StoriteInfo>> buildActionsOnFailedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStdV1<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoriteInfo> enforceCreatedOn = new StdStoriteEnforceCreatedOn(option);
		ActionLazyV1<StoriteInfo> enforceLChanged = new LazyStoriteEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<StoriteInfo> insert = new LazyStoriteDaoInsert(option.conn, option.schemaName);
		
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceCreatedOn);	
		return actions;
	}
}
