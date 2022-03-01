package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.action.SowalagrVisiDaoInsert;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.action.SowalagrVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker.SowalagrCheckExist;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker.SowalagrCheckLangu;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker.SowalagrCheckOwner;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker.SowalagrCheckWrite;


public final class SowalagrRootInsert extends DeciTreeTemplateWrite<SowalagrInfo> {
	
	public SowalagrRootInsert(DeciTreeOption<SowalagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowalagrInfo> buildCheckerHook(DeciTreeOption<SowalagrInfo> option) {
		List<ModelChecker<SowalagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SowalagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowalagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SowalagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SowalagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new SowalagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowalagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowalagrInfo> option) {
		List<ActionStd<SowalagrInfo>> actions = new ArrayList<>();

		ActionStd<SowalagrInfo> enforceLChanged = new ActionStdCommom<SowalagrInfo>(option, SowalagrVisiEnforceLChanged.class);
		ActionLazy<SowalagrInfo> insert = new ActionLazyCommom<SowalagrInfo>(option.conn, option.schemaName, SowalagrVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
