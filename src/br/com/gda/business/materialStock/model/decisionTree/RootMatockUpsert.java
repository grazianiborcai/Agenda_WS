package br.com.gda.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.checker.MatockCheckExist;
import br.com.gda.business.materialStock.model.checker.MatockCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatockUpsert extends DeciTreeWriteTemplate<MatockInfo> {
	
	public RootMatockUpsert(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatockInfo> buildDecisionCheckerHook(DeciTreeOption<MatockInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatockCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();	
		ActionStd<MatockInfo> update = new RootMatockUpdate(option).toAction();	

		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnFailedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();	
		ActionStd<MatockInfo> insert = new RootMatockInsert(option).toAction();	

		actions.add(insert);
		return actions;
	}
}
