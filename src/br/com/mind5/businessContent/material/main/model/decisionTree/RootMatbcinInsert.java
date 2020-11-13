package br.com.mind5.businessContent.material.main.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckOwner;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckStore;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMatbcinInsert extends DeciTreeTemplateWrite<MatbcinInfo> {
	
	public RootMatbcinInsert(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatbcinInfo> buildCheckerHook(DeciTreeOption<MatbcinInfo> option) {
		List<ModelChecker<MatbcinInfo>> queue = new ArrayList<>();		
		ModelChecker<MatbcinInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatbcinCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatbcinCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatbcinCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatbcinInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStd<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatbcinInfo> nodeL1 = new NodeMatbcinInsertL1(option).toAction();
		
		actions.add(nodeL1);		
		return actions;
	}
}
