package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeToSelect;
import br.com.mind5.business.materialText.model.action.StdMatextMergeMatextault;
import br.com.mind5.business.materialText.model.checker.MatextCheckMatextault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextSelectL2 extends DeciTreeWriteTemplate<MatextInfo> {
	
	public NodeMatextSelectL2(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckMatextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> mergeMatextault = new StdMatextMergeMatextault(option);
		ActionLazy<MatextInfo> mergeToSelect = new LazyMatextMergeToSelect(option.conn, option.schemaName);
		
		mergeMatextault.addPostAction(mergeToSelect);
		
		actions.add(mergeMatextault);
		return actions;
	}
}
