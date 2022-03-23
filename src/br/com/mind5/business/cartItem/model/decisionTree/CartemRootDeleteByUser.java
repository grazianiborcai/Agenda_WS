package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.CartemVisiRootDelete;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceUserKey;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeCartemarchUser;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeToSelect;
import br.com.mind5.business.cartItem.model.checker.CartemCheckDeleteByUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartemRootDeleteByUser extends DeciTreeTemplateWrite<CartemInfo> {
	
	public CartemRootDeleteByUser(DeciTreeOption<CartemInfo> option) {
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
		checker = new CartemCheckDeleteByUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceUserKey = new ActionStdCommom<CartemInfo>(option, CartemVisiEnforceUserKey.class);
		ActionLazy<CartemInfo> mergeCartemarch = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeCartemarchUser.class);
		ActionLazy<CartemInfo> select = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeToSelect.class);
		ActionLazy<CartemInfo> delete = new ActionLazyCommom<CartemInfo>(option, CartemVisiRootDelete.class);
		
		enforceUserKey.addPostAction(mergeCartemarch);
		mergeCartemarch.addPostAction(select);
		select.addPostAction(delete);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
