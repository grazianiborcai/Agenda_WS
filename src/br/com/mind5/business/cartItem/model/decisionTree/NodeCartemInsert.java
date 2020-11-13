package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemDaoInsert;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceCreatedOn;
import br.com.mind5.business.cartItem.model.checker.CartemCheckLimit;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartemInsert extends DeciTreeTemplateWriteV2<CartemInfo> {
	
	public NodeCartemInsert(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelCheckerV1<CartemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV2<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CartemInfo> enforceCreatedOn = new StdCartemEnforceCreatedOn(option);	
		ActionLazy<CartemInfo> insert = new LazyCartemDaoInsert(option.conn, option.schemaName);	
		
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
