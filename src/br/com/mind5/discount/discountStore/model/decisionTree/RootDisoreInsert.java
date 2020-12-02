package br.com.mind5.discount.discountStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreDaoInsert;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforceCreatedBy;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforceCreatedOn;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreMergeUsername;
import br.com.mind5.discount.discountStore.model.action.StdDisoreEnforceLChanged;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckDisegy;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckInsert;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckLangu;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckOwner;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckStorauth;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootDisoreInsert extends DeciTreeTemplateWrite<DisoreInfo> {
	
	public RootDisoreInsert(DeciTreeOption<DisoreInfo> option) {
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
		
		ActionStd<DisoreInfo> enforceLChanged = new StdDisoreEnforceLChanged(option);
		ActionLazy<DisoreInfo> enforceLChangedBy = new LazyDisoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> enforceCreatedBy = new LazyDisoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> enforceCreatedOn = new LazyDisoreEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> insert = new LazyDisoreDaoInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
