package br.com.mind5.discount.discountStoreSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.model.action.StdDisorapDaoInsert;
import br.com.mind5.discount.discountStoreSnapshot.model.checker.DisorapCheckDisore;
import br.com.mind5.discount.discountStoreSnapshot.model.checker.DisorapCheckInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootDisorapInsert extends DeciTreeTemplateWrite<DisorapInfo> {
	
	public RootDisorapInsert(DeciTreeOption<DisorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisorapInfo> buildCheckerHook(DeciTreeOption<DisorapInfo> option) {
		List<ModelChecker<DisorapInfo>> queue = new ArrayList<>();		
		ModelChecker<DisorapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new DisorapCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisorapCheckDisore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisorapInfo>> buildActionsOnPassedHook(DeciTreeOption<DisorapInfo> option) {
		List<ActionStd<DisorapInfo>> actions = new ArrayList<>();
		
		ActionStd<DisorapInfo> insert = new StdDisorapDaoInsert(option);
		
		actions.add(insert);
		return actions;
	}
}
