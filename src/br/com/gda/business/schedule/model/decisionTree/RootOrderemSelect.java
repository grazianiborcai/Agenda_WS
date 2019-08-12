package br.com.gda.business.schedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.model.action.LazyOrderemMergeMatsnap;
import br.com.gda.business.schedule.model.action.LazyOrderemNodeSelect;
import br.com.gda.business.schedule.model.action.StdScheduMergeToSelect;
import br.com.gda.business.schedule.model.checker.OrderemCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderemSelect extends DeciTreeWriteTemplate<ScheduInfo> {
	
	public RootOrderemSelect(DeciTreeOption<ScheduInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ScheduInfo> buildDecisionCheckerHook(DeciTreeOption<ScheduInfo> option) {
		List<ModelChecker<ScheduInfo>> queue = new ArrayList<>();		
		ModelChecker<ScheduInfo> checker;
		
		checker = new OrderemCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ScheduInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduInfo> option) {
		List<ActionStd<ScheduInfo>> actions = new ArrayList<>();
		
		ActionStd<ScheduInfo> select = new StdScheduMergeToSelect(option);
		ActionLazy<ScheduInfo> mergeMatsnap = new LazyOrderemMergeMatsnap(option.conn, option.schemaName);
		ActionLazy<ScheduInfo> nodeSelect = new LazyOrderemNodeSelect(option.conn, option.schemaName);		
		
		select.addPostAction(mergeMatsnap);
		mergeMatsnap.addPostAction(nodeSelect);
		
		actions.add(select);
		return actions;
	}
}
