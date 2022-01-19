package br.com.mind5.masterData.petWeightSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;
import br.com.mind5.masterData.petWeightSearch.model.action.StdPeteightarchDaoSelect;
import br.com.mind5.masterData.petWeightSearch.model.checker.PeteightarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPeteightarchSelect extends DeciTreeTemplateWrite<PeteightarchInfo> {
	
	public RootPeteightarchSelect(DeciTreeOption<PeteightarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeteightarchInfo> buildCheckerHook(DeciTreeOption<PeteightarchInfo> option) {
		List<ModelChecker<PeteightarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PeteightarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PeteightarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeteightarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PeteightarchInfo> option) {
		List<ActionStd<PeteightarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PeteightarchInfo> select = new StdPeteightarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
