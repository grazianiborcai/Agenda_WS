package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.LazyPlanataEnforceDaypart;
import br.com.mind5.business.planingData.model.action.LazyPlanataMergeMatlis;
import br.com.mind5.business.planingData.model.action.LazyPlanataMergeMooncal;
import br.com.mind5.business.planingData.model.action.LazyPlanataMergeToSelect;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneAged;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneEmplate;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneStolate;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneStoplis;
import br.com.mind5.business.planingData.model.action.StdPlanataEnforceWeekday;
import br.com.mind5.business.planingData.model.checker.PlanataCheckDate;
import br.com.mind5.business.planingData.model.checker.PlanataCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class RootPlanataSelectNoReserve extends DeciTreeTemplateRead<PlanataInfo> {
	
	public RootPlanataSelectNoReserve(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanataInfo> buildCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PlanataCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PlanataCheckDate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStd<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanataInfo> enforceWeekday = new StdPlanataEnforceWeekday(option);		
		ActionLazy<PlanataInfo> select = new LazyPlanataMergeToSelect(option.conn, option.schemaName);	
		ActionLazy<PlanataInfo> mergeMooncal = new LazyPlanataMergeMooncal(option.conn, option.schemaName);	
		ActionLazy<PlanataInfo> mergeMatlis = new LazyPlanataMergeMatlis(option.conn, option.schemaName);	
		ActionLazy<PlanataInfo> pruneEmplate = new LazyPlanataPruneEmplate(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneStolate = new LazyPlanataPruneStolate(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneAged = new LazyPlanataPruneAged(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneStoplis = new LazyPlanataPruneStoplis(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> enforceDaypart = new LazyPlanataEnforceDaypart(option.conn, option.schemaName);
		
		enforceWeekday.addPostAction(select);
		select.addPostAction(mergeMooncal);
		mergeMooncal.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(pruneEmplate);
		pruneEmplate.addPostAction(pruneStolate);
		pruneStolate.addPostAction(pruneAged);
		pruneAged.addPostAction(pruneStoplis);
		pruneStoplis.addPostAction(enforceDaypart);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
