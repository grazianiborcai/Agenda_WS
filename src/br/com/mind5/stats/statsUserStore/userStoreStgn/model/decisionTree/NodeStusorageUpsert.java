package br.com.mind5.stats.statsUserStore.userStoreStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckExist;


public final class NodeStusorageUpsert extends DeciTreeTemplateWrite<StusorageInfo> {
	
	public NodeStusorageUpsert(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorageInfo> buildCheckerHook(DeciTreeOption<StusorageInfo> option) {
		List<ModelChecker<StusorageInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorageInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorageCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorageInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorageInfo> option) {
		List<ActionStd<StusorageInfo>> actions = new ArrayList<>();

		ActionStd<StusorageInfo> update = new RootStusorageUpdate(option).toAction();
		
		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StusorageInfo>> buildActionsOnFailedHook(DeciTreeOption<StusorageInfo> option) {
		List<ActionStd<StusorageInfo>> actions = new ArrayList<>();

		ActionStd<StusorageInfo> insert = new RootStusorageInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
