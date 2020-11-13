package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.checker.StorextCheckUpsertdel;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStorextUpsertdel extends DeciTreeTemplateWrite<StorextInfo> {
	
	public RootStorextUpsertdel(DeciTreeOption<StorextInfo> option) {
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
		checker = new StorextCheckUpsertdel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextInfo> nodeL1 = new NodeStorextUpsertdelL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
