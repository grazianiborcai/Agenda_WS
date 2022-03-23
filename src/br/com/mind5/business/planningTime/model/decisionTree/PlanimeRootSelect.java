package br.com.mind5.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergeDaypart;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergeEmplres;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergeMatlis;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergeMoonase;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergePlanata;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergeStolis;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiMergeWeekday;
import br.com.mind5.business.planningTime.model.action.PlanimeVisiPruneDaypart;
import br.com.mind5.business.planningTime.model.checker.PlanimeCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public class PlanimeRootSelect extends DeciTreeTemplateWrite<PlanimeInfo> {
	
	public PlanimeRootSelect(DeciTreeOption<PlanimeInfo> option) {
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

		ActionStd<PlanimeInfo> mergePlanata = new ActionStdCommom<PlanimeInfo>(option, PlanimeVisiMergePlanata.class);	
		ActionLazy<PlanimeInfo> pruneDaypart = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiPruneDaypart.class);
		ActionLazy<PlanimeInfo> mergeStolis = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiMergeStolis.class);	
		ActionLazy<PlanimeInfo> mergeEmplres = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiMergeEmplres.class);
		ActionLazy<PlanimeInfo> mergeMatlis = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiMergeMatlis.class);			
		ActionLazy<PlanimeInfo> mergeWeekday = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiMergeWeekday.class);
		ActionLazy<PlanimeInfo> mergeDaypart = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiMergeDaypart.class);
		ActionLazy<PlanimeInfo> mergeMoonase = new ActionLazyCommom<PlanimeInfo>(option, PlanimeVisiMergeMoonase.class);
		
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
