package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.SchedyearVisiMergeMontharch;
import br.com.mind5.business.scheduleYear.model.action.SchedyearVisiMergeSchedyerat;
import br.com.mind5.business.scheduleYear.model.action.SchedyearVisiMergeStolis;
import br.com.mind5.business.scheduleYear.model.checker.SchedyearCheckSchedyerat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedyearNodeSelect extends DeciTreeTemplateWrite<SchedyearInfo> {
	
	public SchedyearNodeSelect(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelChecker<SchedyearInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyearInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyearCheckSchedyerat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> mergeSchedyerat = new ActionStdCommom<SchedyearInfo>(option, SchedyearVisiMergeSchedyerat.class);
		ActionLazy<SchedyearInfo> mergeStolis = new ActionLazyCommom<SchedyearInfo>(option, SchedyearVisiMergeStolis.class);
		ActionLazy<SchedyearInfo> mergeMontharch = new ActionLazyCommom<SchedyearInfo>(option, SchedyearVisiMergeMontharch.class);
		
		mergeSchedyerat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMontharch);
		
		actions.add(mergeSchedyerat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> mergeMontharch = new ActionStdCommom<SchedyearInfo>(option, SchedyearVisiMergeMontharch.class);
		
		actions.add(mergeMontharch);
		return actions;
	}
}
