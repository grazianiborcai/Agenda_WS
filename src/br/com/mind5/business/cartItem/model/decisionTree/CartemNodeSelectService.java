package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceTotitem;
import br.com.mind5.business.cartItem.model.action.CartemVisiEnforceWeekday;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeEmplres;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeMatice;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeMatlis;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeStolis;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeWeekday;
import br.com.mind5.business.cartItem.model.checker.CartemCheckService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartemNodeSelectService extends DeciTreeTemplateWrite<CartemInfo> {
	
	public CartemNodeSelectService(DeciTreeOption<CartemInfo> option) {
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
		checker = new CartemCheckService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> mergeStolis = new ActionStdCommom<CartemInfo>(option, CartemVisiMergeStolis.class);
		ActionLazy<CartemInfo> mergeMatlis = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeMatlis.class);
		ActionLazy<CartemInfo> mergeEmplres = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeEmplres.class);
		ActionLazy<CartemInfo> enforceWeekday = new ActionLazyCommom<CartemInfo>(option, CartemVisiEnforceWeekday.class);
		ActionLazy<CartemInfo> mergeWeekday = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeWeekday.class);
		ActionLazy<CartemInfo> mergeMatice = new ActionLazyCommom<CartemInfo>(option, CartemVisiMergeMatice.class);
		ActionLazy<CartemInfo> enforceTotitem = new ActionLazyCommom<CartemInfo>(option, CartemVisiEnforceTotitem.class);
		
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatice);
		mergeMatice.addPostAction(enforceTotitem);
		
		actions.add(mergeStolis);
		return actions;
	}
}
