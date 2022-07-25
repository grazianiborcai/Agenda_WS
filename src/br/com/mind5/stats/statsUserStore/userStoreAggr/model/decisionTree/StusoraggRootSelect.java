package br.com.mind5.stats.statsUserStore.userStoreAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.statsUserStore.userStoreAggr.model.action.StusoraggVisiMergeCurrency;
import br.com.mind5.stats.statsUserStore.userStoreAggr.model.action.StusoraggVisiMergeToSelect;
import br.com.mind5.stats.statsUserStore.userStoreAggr.model.checker.StusoraggCheckRead;


public final class StusoraggRootSelect extends DeciTreeTemplateWrite<StusoraggInfo> {
	
	public StusoraggRootSelect(DeciTreeOption<StusoraggInfo> option) {
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

		ActionStd<StusoraggInfo> select = new ActionStdCommom<StusoraggInfo>(option, StusoraggVisiMergeToSelect.class);
		ActionLazy<StusoraggInfo> mergeCurrency = new ActionLazyCommom<StusoraggInfo>(option, StusoraggVisiMergeCurrency.class);
		
		select.addPostAction(mergeCurrency);
		
		actions.add(select);
		return actions;
	}
}
