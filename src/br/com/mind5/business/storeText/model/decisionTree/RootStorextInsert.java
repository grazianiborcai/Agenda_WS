package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextNodeInsert;
import br.com.mind5.business.storeText.model.action.LazyStorextRootSelect;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceCreatedBy;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceCreatedOn;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceLChanged;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeUsername;
import br.com.mind5.business.storeText.model.checker.StorextCheckExist;
import br.com.mind5.business.storeText.model.checker.StorextCheckLangu;
import br.com.mind5.business.storeText.model.checker.StorextCheckOwner;
import br.com.mind5.business.storeText.model.checker.StorextCheckStore;
import br.com.mind5.business.storeText.model.checker.StorextCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStorextInsert extends DeciTreeTemplateWrite<StorextInfo> {
	
	public RootStorextInsert(DeciTreeOption<StorextInfo> option) {
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
		checker = new StorextCheckWrite(checkerOption);
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
		checker = new StorextCheckLangu(checkerOption);
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
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new StorextCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorextInfo> nodeDefault = new NodeStorextDefaultL1(option).toAction();	
		ActionLazy<StorextInfo> enforceLChanged = new LazyStorextEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<StorextInfo> enforceLChangedBy = new LazyStorextMergeUsername(option.conn, option.schemaName);		
		ActionLazy<StorextInfo> enforceCreatedBy = new LazyStorextEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<StorextInfo> enforceCreatedOn = new LazyStorextEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StorextInfo> insert = new LazyStorextNodeInsert(option.conn, option.schemaName);
		ActionLazy<StorextInfo> select = new LazyStorextRootSelect(option.conn, option.schemaName);		
		
		nodeDefault.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeDefault);
		return actions;
	}
}
