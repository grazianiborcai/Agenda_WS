package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeCartemarch;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeToSelect;
import br.com.mind5.business.cartItem.model.action.LazyCartemRootDelete;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceUserKey;
import br.com.mind5.business.cartItem.model.checker.CartemCheckDeleteByUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartemDeleteByUser extends DeciTreeWriteTemplate<CartemInfo> {
	
	public RootCartemDeleteByUser(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckDeleteByUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceUserKey = new StdCartemEnforceUserKey(option);
		ActionLazy<CartemInfo> mergeCartemarch = new LazyCartemMergeCartemarch(option.conn, option.schemaName);
		ActionLazy<CartemInfo> select = new LazyCartemMergeToSelect(option.conn, option.schemaName);
		ActionLazy<CartemInfo> delete = new LazyCartemRootDelete(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(mergeCartemarch);
		mergeCartemarch.addPostAction(select);
		select.addPostAction(delete);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
