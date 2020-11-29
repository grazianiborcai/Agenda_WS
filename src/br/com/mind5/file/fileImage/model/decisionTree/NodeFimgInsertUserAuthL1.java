package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootCopyToEmp;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeEmparch;
import br.com.mind5.file.fileImage.model.checker.FimgCheckAuthEmployee;
import br.com.mind5.file.fileImage.model.checker.FimgCheckEmparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeFimgInsertUserAuthL1 extends DeciTreeTemplateWrite<FimgInfo> {
	
	public NodeFimgInsertUserAuthL1(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckAuthEmployee(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckEmparch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeEmparch = new StdFimgMergeEmparch(option);
		ActionLazy<FimgInfo> copy = new LazyFimgRootCopyToEmp(option.conn, option.schemaName);
		
		mergeEmparch.addPostAction(copy);
		
		actions.add(mergeEmparch);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> nodeL2 = new NodeFimgInsertUserAuthL2(option).toAction();
		
		actions.add(nodeL2);		
		return actions;
	}
}
