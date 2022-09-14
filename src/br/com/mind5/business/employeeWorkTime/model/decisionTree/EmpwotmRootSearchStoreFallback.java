package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiEnforceIsDeletedOn;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiEnforceStoreKey;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiMergeStolis;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiMergeWeekdayFallback;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiNodeSearchStoreFallback;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckSearch;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpwotmRootSearchStoreFallback extends DeciTreeTemplateWrite<EmpwotmInfo> {
	
	public EmpwotmRootSearchStoreFallback(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotmCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwotmCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> enforceStoreKey = new ActionStdCommom<EmpwotmInfo>(option, EmpwotmVisiEnforceStoreKey.class);
		ActionLazy<EmpwotmInfo> mergeStolis = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiMergeStolis.class);
		ActionLazy<EmpwotmInfo> enforceIsDeletedOn = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiEnforceIsDeletedOn.class);
		ActionLazy<EmpwotmInfo> mergeWeekday = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiMergeWeekdayFallback.class);
		ActionLazy<EmpwotmInfo> nodeL1 = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiNodeSearchStoreFallback.class);
		
		enforceStoreKey.addPostAction(mergeStolis);
		mergeStolis.addPostAction(enforceIsDeletedOn);
		enforceIsDeletedOn.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(nodeL1);
		
		actions.add(enforceStoreKey);		
		return actions; 
	}
}
