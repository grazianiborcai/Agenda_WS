package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemDaoInsert;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceCreatedOn;
import br.com.mind5.business.cartItem.model.checker.CartemCheckLimit;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCartemInsert extends DeciTreeTemplateWrite<CartemInfo> {
	
	public NodeCartemInsert(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceCreatedOn = new StdCartemEnforceCreatedOn(option);	
		ActionLazy<CartemInfo> insert = new LazyCartemDaoInsert(option.conn, option.schemaName);	
		
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
