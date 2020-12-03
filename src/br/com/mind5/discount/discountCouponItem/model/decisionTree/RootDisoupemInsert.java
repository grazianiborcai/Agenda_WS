package br.com.mind5.discount.discountCouponItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemDaoInsert;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemEnforceCreatedBy;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemEnforceCreatedOn;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemEnforceLChanged;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemMergeUsername;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemRootSelect;
import br.com.mind5.discount.discountCouponItem.model.action.StdDisoupemMergeDisore;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckDisore;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckInsert;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckLangu;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootDisoupemInsert extends DeciTreeTemplateWrite<DisoupemInfo> {
	
	public RootDisoupemInsert(DeciTreeOption<DisoupemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisoupemInfo> buildCheckerHook(DeciTreeOption<DisoupemInfo> option) {
		List<ModelChecker<DisoupemInfo>> queue = new ArrayList<>();		
		ModelChecker<DisoupemInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new DisoupemCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoupemCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoupemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisoupemCheckDisore(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisoupemInfo>> buildActionsOnPassedHook(DeciTreeOption<DisoupemInfo> option) {
		List<ActionStd<DisoupemInfo>> actions = new ArrayList<>();
		//TODO: compute price
		ActionStd<DisoupemInfo> mergeDisore = new StdDisoupemMergeDisore(option);
		ActionLazy<DisoupemInfo> enforceLChanged = new LazyDisoupemEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<DisoupemInfo> enforceLChangedBy = new LazyDisoupemMergeUsername(option.conn, option.schemaName);
		ActionLazy<DisoupemInfo> enforceCreatedBy = new LazyDisoupemEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<DisoupemInfo> enforceCreatedOn = new LazyDisoupemEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<DisoupemInfo> insert = new LazyDisoupemDaoInsert(option.conn, option.schemaName);
		ActionLazy<DisoupemInfo> select = new LazyDisoupemRootSelect(option.conn, option.schemaName);
		
		mergeDisore.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(mergeDisore);
		return actions;
	}
}
