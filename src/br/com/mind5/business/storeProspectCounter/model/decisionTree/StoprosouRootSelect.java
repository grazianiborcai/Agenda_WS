package br.com.mind5.business.storeProspectCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.model.checker.StoprosouCheckLangu;
import br.com.mind5.business.storeProspectCounter.model.checker.StoprosouCheckOwner;
import br.com.mind5.business.storeProspectCounter.model.checker.StoprosouCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StoprosouRootSelect extends DeciTreeTemplateRead<StoprosouInfo> {
	
	public StoprosouRootSelect(DeciTreeOption<StoprosouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprosouInfo> buildCheckerHook(DeciTreeOption<StoprosouInfo> option) {
		List<ModelChecker<StoprosouInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprosouInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoprosouCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoprosouCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoprosouCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprosouInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosouInfo> option) {
		List<ActionStd<StoprosouInfo>> actions = new ArrayList<>();		
		
		ActionStd<StoprosouInfo> nodeL1 = new StoprosouNodeSelect(option).toAction();
		
		actions.add(nodeL1);	
		return actions;
	}
}
