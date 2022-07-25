package br.com.mind5.discount.discountStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiNodeSnapshot;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiRootSelect;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiDaoInsert;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceCreatedBy;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceCreatedOn;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceLChanged;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiMergeUsername;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckDisegy;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckInsert;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckLangu;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckOwner;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckStorauth;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class DisoreRootInsert extends DeciTreeTemplateWrite<DisoreInfo> {
	
	public DisoreRootInsert(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisoreInfo> buildCheckerHook(DeciTreeOption<DisoreInfo> option) {
		List<ModelChecker<DisoreInfo>> queue = new ArrayList<>();		
		ModelChecker<DisoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new DisoreCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoreCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoreCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoreCheckDisegy(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoreCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoreCheckStorauth(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisoreInfo>> buildActionsOnPassedHook(DeciTreeOption<DisoreInfo> option) {
		List<ActionStd<DisoreInfo>> actions = new ArrayList<>();
		
		ActionStd<DisoreInfo> enforceLChanged = new ActionStdCommom<DisoreInfo>(option, DisoreVisiEnforceLChanged.class);
		ActionLazy<DisoreInfo> enforceLChangedBy = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiMergeUsername.class);
		ActionLazy<DisoreInfo> enforceCreatedBy = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforceCreatedBy.class);
		ActionLazy<DisoreInfo> enforceCreatedOn = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforceCreatedOn.class);
		ActionLazy<DisoreInfo> insert = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiDaoInsert.class);
		ActionLazy<DisoreInfo> snapshot = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiNodeSnapshot.class);
		ActionLazy<DisoreInfo> select = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
