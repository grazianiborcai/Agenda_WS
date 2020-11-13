package br.com.mind5.config.sysStoreBusinessContent.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.action.StdSytorbcDaoSelect;
import br.com.mind5.config.sysStoreBusinessContent.model.checker.SytorbcCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSytorbcSelect extends DeciTreeTemplateRead<SytorbcInfo> {
	
	public RootSytorbcSelect(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SytorbcInfo> buildCheckerHook(DeciTreeOption<SytorbcInfo> option) {
		List<ModelChecker<SytorbcInfo>> queue = new ArrayList<>();		
		ModelChecker<SytorbcInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SytorbcCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SytorbcInfo>> buildActionsOnPassedHook(DeciTreeOption<SytorbcInfo> option) {
		List<ActionStd<SytorbcInfo>> actions = new ArrayList<>();
		
		ActionStd<SytorbcInfo> select = new StdSytorbcDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
