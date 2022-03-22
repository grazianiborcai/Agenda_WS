package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action.CutefilonagrVisiDaoInsert;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action.CutefilonagrVisiEnforceLChanged;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckExist;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckLangu;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckOwner;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckStore;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.checker.CutefilonagrCheckWrite;


public final class CutefilonagrRootInsert extends DeciTreeTemplateWrite<CutefilonagrInfo> {
	
	public CutefilonagrRootInsert(DeciTreeOption<CutefilonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefilonagrInfo> buildCheckerHook(DeciTreeOption<CutefilonagrInfo> option) {
		List<ModelChecker<CutefilonagrInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefilonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CutefilonagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefilonagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefilonagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefilonagrCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new CutefilonagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefilonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefilonagrInfo> option) {
		List<ActionStd<CutefilonagrInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonagrInfo> enforceLChanged = new ActionStdCommom<CutefilonagrInfo>(option, CutefilonagrVisiEnforceLChanged.class);
		ActionLazy<CutefilonagrInfo> insert = new ActionLazyCommom<CutefilonagrInfo>(option, CutefilonagrVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
