package br.com.mind5.masterData.prospectStatusSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.masterData.prospectStatusSearch.model.action.StdProstarchDaoSelect;
import br.com.mind5.masterData.prospectStatusSearch.model.checker.ProstarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootProstarchSelect extends DeciTreeTemplateWrite<ProstarchInfo> {
	
	public RootProstarchSelect(DeciTreeOption<ProstarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ProstarchInfo> buildCheckerHook(DeciTreeOption<ProstarchInfo> option) {
		List<ModelChecker<ProstarchInfo>> queue = new ArrayList<>();		
		ModelChecker<ProstarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ProstarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ProstarchInfo>> buildActionsOnPassedHook(DeciTreeOption<ProstarchInfo> option) {
		List<ActionStd<ProstarchInfo>> actions = new ArrayList<>();
		
		ActionStd<ProstarchInfo> select = new StdProstarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
