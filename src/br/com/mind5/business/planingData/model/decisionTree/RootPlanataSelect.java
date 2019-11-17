package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.LazyPlanataMergeMat;
import br.com.mind5.business.planingData.model.action.LazyPlanataMergeToSelect;
import br.com.mind5.business.planingData.model.action.LazyPlanataNodeReserve;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneAged;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneEmplate;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneStolate;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneStopar;
import br.com.mind5.business.planingData.model.action.StdPlanataEnforceWeekday;
import br.com.mind5.business.planingData.model.checker.PlanataCheckDate;
import br.com.mind5.business.planingData.model.checker.PlanataCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public class RootPlanataSelect extends DeciTreeReadTemplate<PlanataInfo> {
	
	public RootPlanataSelect(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanataInfo> buildDecisionCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;
		
		checker = new PlanataCheckRead();
		queue.add(checker);
		
		checker = new PlanataCheckDate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStd<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanataInfo> enforceWeekday = new StdPlanataEnforceWeekday(option);		
		ActionLazy<PlanataInfo> select = new LazyPlanataMergeToSelect(option.conn, option.schemaName);		
		ActionLazy<PlanataInfo> mergeMat = new LazyPlanataMergeMat(option.conn, option.schemaName);	
		ActionLazy<PlanataInfo> pruneEmplate = new LazyPlanataPruneEmplate(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneStolate = new LazyPlanataPruneStolate(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneAged = new LazyPlanataPruneAged(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneStopar = new LazyPlanataPruneStopar(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> nodeReserve = new LazyPlanataNodeReserve(option.conn, option.schemaName);
		
		enforceWeekday.addPostAction(select);
		select.addPostAction(mergeMat);
		mergeMat.addPostAction(pruneEmplate);
		pruneEmplate.addPostAction(pruneStolate);
		pruneStolate.addPostAction(pruneAged);
		pruneAged.addPostAction(pruneStopar);
		pruneStopar.addPostAction(nodeReserve);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
