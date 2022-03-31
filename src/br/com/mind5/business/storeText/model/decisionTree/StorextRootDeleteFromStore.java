package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StorextVisiRootDelete;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeStorextarch;
import br.com.mind5.business.storeText.model.checker.StorextCheckDeleteFromStore;
import br.com.mind5.business.storeText.model.checker.StorextCheckOwner;
import br.com.mind5.business.storeText.model.checker.StorextCheckStore;
import br.com.mind5.business.storeText.model.checker.StorextCheckStorextarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StorextRootDeleteFromStore extends DeciTreeTemplateWrite<StorextInfo> {

	public StorextRootDeleteFromStore(DeciTreeOption<StorextInfo> option) {
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
		checker = new StorextCheckDeleteFromStore(checkerOption);
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
		checker = new StorextCheckStorextarch(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();

		ActionStd<StorextInfo> mergeStorextarch = new ActionStdCommom<StorextInfo>(option, StorextVisiMergeStorextarch.class);
		ActionLazy<StorextInfo> delete = new ActionLazyCommom<StorextInfo>(option, StorextVisiRootDelete.class);
		
		mergeStorextarch.addPostAction(delete);
		
		actions.add(mergeStorextarch);
		return actions;
	}
}
