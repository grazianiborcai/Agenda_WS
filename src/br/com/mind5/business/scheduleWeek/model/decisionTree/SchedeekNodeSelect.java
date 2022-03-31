package br.com.mind5.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeCalate;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeCalimemp;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeCalimore;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeCuslis;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeEmplres;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeMatlis;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeSchedeekdat;
import br.com.mind5.business.scheduleWeek.model.action.SchedeekVisiMergeStolis;
import br.com.mind5.business.scheduleWeek.model.checker.SchedeekCheckSchedeekdat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedeekNodeSelect extends DeciTreeTemplateWrite<SchedeekInfo> {
	
	public SchedeekNodeSelect(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekInfo> buildCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelChecker<SchedeekInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new SchedeekCheckSchedeekdat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStd<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekInfo> mergeSchedeekdat = new ActionStdCommom<SchedeekInfo>(option, SchedeekVisiMergeSchedeekdat.class);
		ActionLazy<SchedeekInfo> mergeStolis = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeStolis.class);
		ActionLazy<SchedeekInfo> mergeMatlis = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeMatlis.class);
		ActionLazy<SchedeekInfo> mergeEmplres = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeEmplres.class);
		ActionLazy<SchedeekInfo> mergeCuslis = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeCuslis.class);
		ActionLazy<SchedeekInfo> mergeCalate = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeCalate.class);
		ActionLazy<SchedeekInfo> mergeCalimore = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeCalimore.class);
		ActionLazy<SchedeekInfo> mergeCalimemp = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeCalimemp.class);
		
		mergeSchedeekdat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeCalate);
		mergeCalate.addPostAction(mergeCalimore);
		mergeCalimore.addPostAction(mergeCalimemp);
		
		actions.add(mergeSchedeekdat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedeekInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStd<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekInfo> mergeCalate = new ActionStdCommom<SchedeekInfo>(option, SchedeekVisiMergeCalate.class);
		ActionLazy<SchedeekInfo> mergeCalimore = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeCalimore.class);
		ActionLazy<SchedeekInfo> mergeCalimemp = new ActionLazyCommom<SchedeekInfo>(option, SchedeekVisiMergeCalimemp.class);
		
		mergeCalate.addPostAction(mergeCalimore);
		mergeCalimore.addPostAction(mergeCalimemp);
		
		actions.add(mergeCalate);
		return actions;
	}
}
