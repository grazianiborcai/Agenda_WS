package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.checker.StorextCheckIsDefault;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeStorextDefaultL1 extends DeciTreeTemplateWrite<StorextInfo> {
	
	public NodeStorextDefaultL1(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelChecker<StorextInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextCheckIsDefault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();

		ActionStd<StorextInfo> nodeL2 = new NodeStorextDefaultL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();

		ActionStd<StorextInfo> nodeL3 = new NodeStorextDefaultL3(option).toAction();	
		
		actions.add(nodeL3);		
		return actions;
	}
}
