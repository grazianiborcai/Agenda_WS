package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceAged;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceSymsgL04;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeSymsg;
import br.com.mind5.business.cartItem.model.checker.CartemCheckMatore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartemNodeAgedServiceL04 extends DeciTreeTemplateWrite<CartemInfo> {
	
	public CartemNodeAgedServiceL04(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartemCheckMatore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> nodeL05 = new CartemNodeAgedServiceL05(option).toAction();	
		
		actions.add(nodeL05);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnFailedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceSymsg = new ActionStdCommom<CartemInfo>(option, CartemVisiEnforceSymsgL04.class);	
		ActionLazy<CartemInfo> mergeSymsg = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeSymsg.class);
		ActionLazy<CartemInfo> enforceAged = new ActionLazyCommom<CartemInfo>(option, CartemVisiEnforceAged.class);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
