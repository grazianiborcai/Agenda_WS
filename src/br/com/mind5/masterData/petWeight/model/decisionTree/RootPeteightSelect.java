package br.com.mind5.masterData.petWeight.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.masterData.petWeight.model.action.StdPeteightDaoSelect;
import br.com.mind5.masterData.petWeight.model.checker.PeteightCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPeteightSelect extends DeciTreeTemplateRead<PeteightInfo> {
	
	public RootPeteightSelect(DeciTreeOption<PeteightInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeteightInfo> buildCheckerHook(DeciTreeOption<PeteightInfo> option) {
		List<ModelChecker<PeteightInfo>> queue = new ArrayList<>();		
		ModelChecker<PeteightInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PeteightCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeteightInfo>> buildActionsOnPassedHook(DeciTreeOption<PeteightInfo> option) {
		List<ActionStd<PeteightInfo>> actions = new ArrayList<>();
		
		ActionStd<PeteightInfo> select = new StdPeteightDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
