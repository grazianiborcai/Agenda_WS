package br.com.gda.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.LazyCartemInsert;
import br.com.gda.business.cartItem.model.action.LazyCartemUpdate;
import br.com.gda.business.cartItem.model.action.StdCartemEnforceCreatedOn;
import br.com.gda.business.cartItem.model.action.StdCartemMergeToUpdate;
import br.com.gda.business.cartItem.model.checker.CartemCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartemUpsert extends DeciTreeWriteTemplate<CartemInfo> {
	
	public NodeCartemUpsert(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> mergeToUpdate = new StdCartemMergeToUpdate(option);	
		ActionLazy<CartemInfo> update = new LazyCartemUpdate(option.conn, option.schemaName);			
		
		mergeToUpdate.addPostAction(update);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnFailedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceCreatedOn = new StdCartemEnforceCreatedOn(option);	
		ActionLazy<CartemInfo> insert = new LazyCartemInsert(option.conn, option.schemaName);	
		
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
