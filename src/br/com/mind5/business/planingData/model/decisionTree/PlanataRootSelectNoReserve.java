package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.PlanataVisiEnforceDaypart;
import br.com.mind5.business.planingData.model.action.PlanataVisiEnforceWeekday;
import br.com.mind5.business.planingData.model.action.PlanataVisiMergeMatice;
import br.com.mind5.business.planingData.model.action.PlanataVisiMergeMatlis;
import br.com.mind5.business.planingData.model.action.PlanataVisiMergeMooncal;
import br.com.mind5.business.planingData.model.action.PlanataVisiMergeToSelect;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneAged;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneEmplate;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneStolate;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneStoplis;
import br.com.mind5.business.planingData.model.checker.PlanataCheckDate;
import br.com.mind5.business.planingData.model.checker.PlanataCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class PlanataRootSelectNoReserve extends DeciTreeTemplateRead<PlanataInfo> {
	
	public PlanataRootSelectNoReserve(DeciTreeOption<PlanataInfo> option) {
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
		
		ActionStd<PlanataInfo> enforceWeekday = new ActionStdCommom<PlanataInfo>(option, PlanataVisiEnforceWeekday.class);		
		ActionLazy<PlanataInfo> select = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiMergeToSelect.class);	
		ActionLazy<PlanataInfo> mergeMooncal = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiMergeMooncal.class);
		ActionLazy<PlanataInfo> mergeMatice = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiMergeMatice.class);	
		ActionLazy<PlanataInfo> mergeMatlis = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiMergeMatlis.class);	
		ActionLazy<PlanataInfo> pruneEmplate = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiPruneEmplate.class);
		ActionLazy<PlanataInfo> pruneStolate = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiPruneStolate.class);
		ActionLazy<PlanataInfo> pruneAged = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiPruneAged.class);
		ActionLazy<PlanataInfo> pruneStoplis = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiPruneStoplis.class);
		ActionLazy<PlanataInfo> enforceDaypart = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiEnforceDaypart.class);
		
		enforceWeekday.addPostAction(select);
		select.addPostAction(mergeMooncal);
		mergeMooncal.addPostAction(mergeMatice);
		mergeMatice.addPostAction(mergeMatlis);		
		mergeMatlis.addPostAction(pruneEmplate);
		pruneEmplate.addPostAction(pruneStolate);
		pruneStolate.addPostAction(pruneAged);
		pruneAged.addPostAction(pruneStoplis);
		pruneStoplis.addPostAction(enforceDaypart);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
