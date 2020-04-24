package br.com.mind5.business.planingDataSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.model.action.LazyPlanarchPruneSel;
import br.com.mind5.business.planingDataSearch.model.action.StdPlanarchMergePlanata;
import br.com.mind5.business.planingDataSearch.model.checker.PlanarchCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public class RootPlanarchSelect extends DeciTreeTemplateReadV2<PlanarchInfo> {
	
	public RootPlanarchSelect(DeciTreeOption<PlanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PlanarchInfo> buildCheckerHook(DeciTreeOption<PlanarchInfo> option) {
		List<ModelCheckerV1<PlanarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PlanarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PlanarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PlanarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanarchInfo> option) {
		List<ActionStdV1<PlanarchInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PlanarchInfo> mergePlanata = new StdPlanarchMergePlanata(option);	
		ActionLazyV1<PlanarchInfo> pruneSel = new LazyPlanarchPruneSel(option.conn, option.schemaName);
		
		mergePlanata.addPostAction(pruneSel);
		
		actions.add(mergePlanata);
		return actions;
	}
}
