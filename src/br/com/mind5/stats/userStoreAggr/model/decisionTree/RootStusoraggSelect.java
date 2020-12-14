package br.com.mind5.stats.userStoreAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.userStoreAggr.model.action.LazyStusoraggMergeCurrency;
import br.com.mind5.stats.userStoreAggr.model.action.StdStusoraggMergeToSelect;
import br.com.mind5.stats.userStoreAggr.model.checker.StusoraggCheckRead;


public final class RootStusoraggSelect extends DeciTreeTemplateWrite<StusoraggInfo> {
	
	public RootStusoraggSelect(DeciTreeOption<StusoraggInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoraggInfo> buildCheckerHook(DeciTreeOption<StusoraggInfo> option) {
		List<ModelChecker<StusoraggInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoraggInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusoraggCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoraggInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoraggInfo> option) {
		List<ActionStd<StusoraggInfo>> actions = new ArrayList<>();

		ActionStd<StusoraggInfo> select = new StdStusoraggMergeToSelect(option);
		ActionLazy<StusoraggInfo> mergeCurrency = new LazyStusoraggMergeCurrency(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		
		actions.add(select);
		return actions;
	}
}
