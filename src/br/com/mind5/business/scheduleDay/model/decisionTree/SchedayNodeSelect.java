package br.com.mind5.business.scheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeCalate;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeCalimore;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeCuslis;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeEmplres;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeMatlis;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeSchedatus;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeSchedayta;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeStolis;
import br.com.mind5.business.scheduleDay.model.checker.SchedayCheckSchedayta;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedayNodeSelect extends DeciTreeTemplateWrite<SchedayInfo> {
	
	public SchedayNodeSelect(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedayInfo> buildCheckerHook(DeciTreeOption<SchedayInfo> option) {
		List<ModelChecker<SchedayInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedayInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedayCheckSchedayta(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedayInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStd<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedayInfo> mergeSchedayta = new ActionStdCommom<SchedayInfo>(option, SchedayVisiMergeSchedayta.class);
		ActionLazy<SchedayInfo> mergeStolis = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeStolis.class);
		ActionLazy<SchedayInfo> mergeMatlis = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeMatlis.class);
		ActionLazy<SchedayInfo> mergeEmplres = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeEmplres.class);
		ActionLazy<SchedayInfo> mergeCuslis = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeCuslis.class);
		ActionLazy<SchedayInfo> mergeSchedatus = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeSchedatus.class);
		ActionLazy<SchedayInfo> mergeCalate = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeCalate.class);
		ActionLazy<SchedayInfo> mergeCalimore = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeCalimore.class);
		
		mergeSchedayta.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeSchedatus);
		mergeSchedatus.addPostAction(mergeCalate);
		mergeCalate.addPostAction(mergeCalimore);
		
		actions.add(mergeSchedayta);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedayInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStd<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedayInfo> mergeCalate = new ActionStdCommom<SchedayInfo>(option, SchedayVisiMergeCalate.class);
		ActionLazy<SchedayInfo> mergeCalimore = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiMergeCalimore.class);
		
		mergeCalate.addPostAction(mergeCalimore);
		
		actions.add(mergeCalate);
		return actions;
	} 
}
