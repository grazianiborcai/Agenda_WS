package br.com.mind5.business.planingDataSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.model.action.PlanarchVisiMergePlanata;
import br.com.mind5.business.planingDataSearch.model.action.PlanarchVisiPruneSel;
import br.com.mind5.business.planingDataSearch.model.checker.PlanarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class PlanarchRootSelect extends DeciTreeTemplateRead<PlanarchInfo> {
	
	public PlanarchRootSelect(DeciTreeOption<PlanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanarchInfo> buildCheckerHook(DeciTreeOption<PlanarchInfo> option) {
		List<ModelChecker<PlanarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PlanarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanarchInfo> option) {
		List<ActionStd<PlanarchInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanarchInfo> mergePlanata = new ActionStdCommom<PlanarchInfo>(option, PlanarchVisiMergePlanata.class);	
		ActionLazy<PlanarchInfo> pruneSel = new ActionLazyCommom<PlanarchInfo>(option, PlanarchVisiPruneSel.class);
		
		mergePlanata.addPostAction(pruneSel);
		
		actions.add(mergePlanata);
		return actions;
	}
}
