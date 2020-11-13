package br.com.mind5.businessContent.material.main.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinMatbcetInsert;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinSuccess;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckIsPetshop;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatbcinInsertL2 extends DeciTreeTemplateWrite<MatbcinInfo> {
	
	public NodeMatbcinInsertL2(DeciTreeOption<MatbcinInfo> option) {
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
		checker = new MatbcinCheckIsPetshop(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatbcinInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStd<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatbcinInfo> insertMatbcet = new StdMatbcinMatbcetInsert(option);
		
		actions.add(insertMatbcet);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatbcinInfo>> buildActionsOnFailedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStd<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatbcinInfo> success = new StdMatbcinSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
