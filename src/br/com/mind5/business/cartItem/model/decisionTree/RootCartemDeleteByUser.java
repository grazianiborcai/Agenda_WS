package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeCartemarch;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeToSelect;
import br.com.mind5.business.cartItem.model.action.LazyCartemRootDelete;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceUserKey;
import br.com.mind5.business.cartItem.model.checker.CartemCheckDeleteByUser;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
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
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> enforceUserKey = new StdCartemEnforceUserKey(option);
		ActionLazyV1<CartemInfo> mergeCartemarch = new LazyCartemMergeCartemarch(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> select = new LazyCartemMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> delete = new LazyCartemRootDelete(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(mergeCartemarch);
		mergeCartemarch.addPostAction(select);
		select.addPostAction(delete);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
