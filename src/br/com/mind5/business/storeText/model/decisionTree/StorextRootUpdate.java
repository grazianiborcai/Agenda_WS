package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StorextVisiDaoUpdate;
import br.com.mind5.business.storeText.model.action.StorextVisiEnforceLChanged;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeToUpdate;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeUsername;
import br.com.mind5.business.storeText.model.action.StorextVisiNodeDefaultL1;
import br.com.mind5.business.storeText.model.action.StorextVisiNodePostUpdate;
import br.com.mind5.business.storeText.model.action.StorextVisiRootSelect;
import br.com.mind5.business.storeText.model.checker.StorextCheckSafeDescription;
import br.com.mind5.business.storeText.model.checker.StorextCheckExist;
import br.com.mind5.business.storeText.model.checker.StorextCheckLangu;
import br.com.mind5.business.storeText.model.checker.StorextCheckOwner;
import br.com.mind5.business.storeText.model.checker.StorextCheckStore;
import br.com.mind5.business.storeText.model.checker.StorextCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StorextRootUpdate extends DeciTreeTemplateWrite<StorextInfo> {
	
	public StorextRootUpdate(DeciTreeOption<StorextInfo> option) {
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
		checker = new StorextCheckSafeDescription(checkerOption);
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();

		ActionStd<StorextInfo> mergeToUpdate = new ActionStdCommom<StorextInfo>(option, StorextVisiMergeToUpdate.class);
		ActionLazy<StorextInfo> nodeDefault = new ActionLazyCommom<StorextInfo>(option, StorextVisiNodeDefaultL1.class);
		ActionLazy<StorextInfo> enforceLChanged = new ActionLazyCommom<StorextInfo>(option, StorextVisiEnforceLChanged.class);	
		ActionLazy<StorextInfo> enforceLChangedBy = new ActionLazyCommom<StorextInfo>(option, StorextVisiMergeUsername.class);
		ActionLazy<StorextInfo> update = new ActionLazyCommom<StorextInfo>(option, StorextVisiDaoUpdate.class);
		ActionLazy<StorextInfo> postUpdate = new ActionLazyCommom<StorextInfo>(option, StorextVisiNodePostUpdate.class);
		ActionLazy<StorextInfo> select = new ActionLazyCommom<StorextInfo>(option, StorextVisiRootSelect.class);	
		
		mergeToUpdate.addPostAction(nodeDefault);
		nodeDefault.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(postUpdate);
		postUpdate.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
