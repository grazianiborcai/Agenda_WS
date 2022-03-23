package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceAged;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceSymsgL11;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeSymsg;
import br.com.mind5.business.cartItem.model.checker.CartemCheckStolarg;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartemNodeAgedServiceL11 extends DeciTreeTemplateWrite<CartemInfo> {
	
	public CartemNodeAgedServiceL11(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new CartemCheckStolarg(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> nodeL12 = new CartemNodeAgedServiceL12(option).toAction();	
		
		actions.add(nodeL12);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnFailedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceSymsg = new ActionStdCommom<CartemInfo>(option, CartemVisiEnforceSymsgL11.class);	
		ActionLazy<CartemInfo> mergeSymsg = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeSymsg.class);
		ActionLazy<CartemInfo> enforceAged = new ActionLazyCommom<CartemInfo>(option, CartemVisiEnforceAged.class);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
