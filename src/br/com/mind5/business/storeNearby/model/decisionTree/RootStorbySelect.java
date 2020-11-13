package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckReadName;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStorbySelect extends DeciTreeTemplateRead<StorbyInfo> {
	
	public RootStorbySelect(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelChecker<StorbyInfo>> queue = new ArrayList<>();		
		ModelChecker<StorbyInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorbyCheckReadName(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> selectName = new RootStorbySelectName(option).toAction();
		
		actions.add(selectName);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnFailedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> nodeL1 = new NodeStorbySelectL1(option).toAction();
		
		actions.add(nodeL1);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
