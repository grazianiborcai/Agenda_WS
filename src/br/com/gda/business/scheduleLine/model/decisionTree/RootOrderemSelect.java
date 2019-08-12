package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazyOrderemMergeMatsnap;
import br.com.gda.business.scheduleLine.model.action.LazyOrderemNodeSelect;
import br.com.gda.business.scheduleLine.model.action.StdSchedineMergeToSelect;
import br.com.gda.business.scheduleLine.model.checker.OrderemCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderemSelect extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public RootOrderemSelect(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;
		
		checker = new OrderemCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> select = new StdSchedineMergeToSelect(option);
		ActionLazy<SchedineInfo> mergeMatsnap = new LazyOrderemMergeMatsnap(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeSelect = new LazyOrderemNodeSelect(option.conn, option.schemaName);		
		
		select.addPostAction(mergeMatsnap);
		mergeMatsnap.addPostAction(nodeSelect);
		
		actions.add(select);
		return actions;
	}
}
