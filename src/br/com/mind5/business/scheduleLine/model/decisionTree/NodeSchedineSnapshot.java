package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineUpdate;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineInsertSchedinap;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineSnapshot extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineSnapshot(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckInsert();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> insertSchedinap = new StdSchedineInsertSchedinap(option);
		ActionLazy<SchedineInfo> update = new LazySchedineUpdate(option.conn, option.schemaName);
		
		insertSchedinap.addPostAction(update);
		
		actions.add(insertSchedinap);
		return actions;
	}
}
