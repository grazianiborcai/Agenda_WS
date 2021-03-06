package br.com.mind5.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeDaypart;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeEmplres;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeMatlis;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeMoonase;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeStolis;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeWeekday;
import br.com.mind5.business.planningTime.model.action.LazyPlanimePruneDaypart;
import br.com.mind5.business.planningTime.model.action.StdPlanimeMergePlanata;
import br.com.mind5.business.planningTime.model.checker.PlanimeCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public class RootPlanimeSelect extends DeciTreeTemplateWrite<PlanimeInfo> {
	
	public RootPlanimeSelect(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanimeInfo> buildCheckerHook(DeciTreeOption<PlanimeInfo> option) {
		List<ModelChecker<PlanimeInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanimeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PlanimeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanimeInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanimeInfo> option) {
		List<ActionStd<PlanimeInfo>> actions = new ArrayList<>();		

		ActionStd<PlanimeInfo> mergePlanata = new StdPlanimeMergePlanata(option);	
		ActionLazy<PlanimeInfo> pruneDaypart = new LazyPlanimePruneDaypart(option.conn, option.schemaName);
		ActionLazy<PlanimeInfo> mergeStolis = new LazyPlanimeMergeStolis(option.conn, option.schemaName);	
		ActionLazy<PlanimeInfo> mergeEmplres = new LazyPlanimeMergeEmplres(option.conn, option.schemaName);
		ActionLazy<PlanimeInfo> mergeMatlis = new LazyPlanimeMergeMatlis(option.conn, option.schemaName);			
		ActionLazy<PlanimeInfo> mergeWeekday = new LazyPlanimeMergeWeekday(option.conn, option.schemaName);
		ActionLazy<PlanimeInfo> mergeDaypart = new LazyPlanimeMergeDaypart(option.conn, option.schemaName);
		ActionLazy<PlanimeInfo> mergeMoonase = new LazyPlanimeMergeMoonase(option.conn, option.schemaName);
		
		mergePlanata.addPostAction(pruneDaypart);
		pruneDaypart.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeDaypart);
		mergeDaypart.addPostAction(mergeMoonase);
		
		actions.add(mergePlanata);
		return actions;
	}
}
