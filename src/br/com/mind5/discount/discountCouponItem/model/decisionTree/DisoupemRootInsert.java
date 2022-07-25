package br.com.mind5.discount.discountCouponItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiRootSelect;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiDaoInsert;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiEnforceCreatedBy;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiEnforceCreatedOn;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiEnforceLChanged;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiMergeDisore;
import br.com.mind5.discount.discountCouponItem.model.action.DisoupemVisiMergeUsername;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckDisore;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckInsert;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckLangu;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class DisoupemRootInsert extends DeciTreeTemplateWrite<DisoupemInfo> {
	
	public DisoupemRootInsert(DeciTreeOption<DisoupemInfo> option) {
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
		ActionStd<DisoupemInfo> mergeDisore = new ActionStdCommom<DisoupemInfo>(option, DisoupemVisiMergeDisore.class);
		ActionLazy<DisoupemInfo> enforceLChanged = new ActionLazyCommom<DisoupemInfo>(option, DisoupemVisiEnforceLChanged.class);
		ActionLazy<DisoupemInfo> enforceLChangedBy = new ActionLazyCommom<DisoupemInfo>(option, DisoupemVisiMergeUsername.class);
		ActionLazy<DisoupemInfo> enforceCreatedBy = new ActionLazyCommom<DisoupemInfo>(option, DisoupemVisiEnforceCreatedBy.class);
		ActionLazy<DisoupemInfo> enforceCreatedOn = new ActionLazyCommom<DisoupemInfo>(option, DisoupemVisiEnforceCreatedOn.class);
		ActionLazy<DisoupemInfo> insert = new ActionLazyCommom<DisoupemInfo>(option, DisoupemVisiDaoInsert.class);
		ActionLazy<DisoupemInfo> select = new ActionLazyCommom<DisoupemInfo>(option, DisoupemVisiRootSelect.class);
		
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
