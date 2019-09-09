package br.com.gda.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.business.scheduleWeek.model.action.LazySchedeekMergeCuslis;
import br.com.gda.business.scheduleWeek.model.action.LazySchedeekMergeEmplis;
import br.com.gda.business.scheduleWeek.model.action.LazySchedeekMergeMat;
import br.com.gda.business.scheduleWeek.model.action.LazySchedeekMergeStolis;
import br.com.gda.business.scheduleWeek.model.action.StdSchedeekMergeSchedeekdat;
import br.com.gda.business.scheduleWeek.model.checker.SchedeekCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedeekSelect extends DeciTreeWriteTemplate<SchedeekInfo> {
	
	public RootSchedeekSelect(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekInfo> buildDecisionCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelChecker<SchedeekInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekInfo> checker;	
		
		checker = new SchedeekCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStd<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekInfo> mergeSchedeekdat = new StdSchedeekMergeSchedeekdat(option);
		ActionLazy<SchedeekInfo> mergeStolis = new LazySchedeekMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedeekInfo> mergeMat = new LazySchedeekMergeMat(option.conn, option.schemaName);
		ActionLazy<SchedeekInfo> mergeEmplis = new LazySchedeekMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedeekInfo> mergeCuslis = new LazySchedeekMergeCuslis(option.conn, option.schemaName);
		
		mergeSchedeekdat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeCuslis);
		
		actions.add(mergeSchedeekdat);
		return actions;
	}
}
