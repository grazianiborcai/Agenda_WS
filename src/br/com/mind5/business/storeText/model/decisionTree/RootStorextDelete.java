package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextNodeDeleteL1;
import br.com.mind5.business.storeText.model.action.LazyStorextNodeDeleteL2;
import br.com.mind5.business.storeText.model.action.StdStorextMergeToDelete;
import br.com.mind5.business.storeText.model.checker.StorextCheckDelete;
import br.com.mind5.business.storeText.model.checker.StorextCheckExist;
import br.com.mind5.business.storeText.model.checker.StorextCheckLangu;
import br.com.mind5.business.storeText.model.checker.StorextCheckStore;
import br.com.mind5.business.storeText.model.checker.StorextCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStorextDelete extends DeciTreeTemplateWrite<StorextInfo> {
	
	public RootStorextDelete(DeciTreeOption<StorextInfo> option) {
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
		checker = new StorextCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorextCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorextCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorextCheckStore(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorextCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueue<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextInfo> mergeToDelete = new StdStorextMergeToDelete(option);
		ActionLazy<StorextInfo> nodeL1 = new LazyStorextNodeDeleteL1(option.conn, option.schemaName);
		ActionLazy<StorextInfo> nodeL2 = new LazyStorextNodeDeleteL2(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(nodeL1);
		mergeToDelete.addPostAction(nodeL2);		
		
		actions.add(mergeToDelete);
		return actions;
	}
}
