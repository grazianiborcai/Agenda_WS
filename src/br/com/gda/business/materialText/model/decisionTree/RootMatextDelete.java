package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextNodeDelete;
import br.com.gda.business.materialText.model.action.StdMatextMergeToDelete;
import br.com.gda.business.materialText.model.checker.MatextCheckDelete;
import br.com.gda.business.materialText.model.checker.MatextCheckExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextDelete extends DeciTreeWriteTemplate<MatextInfo> {
	
	public RootMatextDelete(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new MatextCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> mergeToDelete = new StdMatextMergeToDelete(option);
		ActionLazy<MatextInfo> nodeDelete = new LazyMatextNodeDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(nodeDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
