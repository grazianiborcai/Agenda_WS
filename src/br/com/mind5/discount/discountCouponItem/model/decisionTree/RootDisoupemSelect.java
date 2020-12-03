package br.com.mind5.discount.discountCouponItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.action.LazyDisoupemMergeDisorap;
import br.com.mind5.discount.discountCouponItem.model.action.StdDisoupemMergeToSelect;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckLangu;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckOwner;
import br.com.mind5.discount.discountCouponItem.model.checker.DisoupemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootDisoupemSelect extends DeciTreeTemplateRead<DisoupemInfo> {
	
	public RootDisoupemSelect(DeciTreeOption<DisoupemInfo> option) {
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
		checker = new DisoupemCheckRead(checkerOption);
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisoupemInfo>> buildActionsOnPassedHook(DeciTreeOption<DisoupemInfo> option) {
		List<ActionStd<DisoupemInfo>> actions = new ArrayList<>();
		
		ActionStd<DisoupemInfo> select = new StdDisoupemMergeToSelect(option);
		ActionLazy<DisoupemInfo> mergeDisorap = new LazyDisoupemMergeDisorap(option.conn, option.schemaName);
		
		select.addPostAction(mergeDisorap);
		
		actions.add(select);
		return actions;
	}
}
