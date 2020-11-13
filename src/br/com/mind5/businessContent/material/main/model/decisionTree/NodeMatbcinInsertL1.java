package br.com.mind5.businessContent.material.main.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.action.LazyMatbcinNodeInsertL2;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinMergeOwnelis;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinSuccess;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckSytorbc;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckSytotin;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatbcinInsertL1 extends DeciTreeTemplateWrite<MatbcinInfo> {
	
	public NodeMatbcinInsertL1(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatbcinInfo> buildCheckerHook(DeciTreeOption<MatbcinInfo> option) {
		List<ModelChecker<MatbcinInfo>> queue = new ArrayList<>();		
		ModelChecker<MatbcinInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatbcinCheckSytotin(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatbcinCheckSytorbc(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatbcinInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStd<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatbcinInfo> mergeOwnelis = new StdMatbcinMergeOwnelis(option);
		ActionLazy<MatbcinInfo> nodeL2 = new LazyMatbcinNodeInsertL2(option.conn, option.schemaName);
		
		mergeOwnelis.addPostAction(nodeL2);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatbcinInfo>> buildActionsOnFailedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStd<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatbcinInfo> success = new StdMatbcinSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
