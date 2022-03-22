package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action.CutefiloniveVisiEnforceLChanged;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action.CutefiloniveVisiMergeCalonth;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action.CutefiloniveVisiMergeToSelect;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker.CutefiloniveCheckLangu;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker.CutefiloniveCheckOwner;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker.CutefiloniveCheckRead;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker.CutefiloniveCheckCus;


public final class CutefiloniveRootSelect extends DeciTreeTemplateWrite<CutefiloniveInfo> {
	
	public CutefiloniveRootSelect(DeciTreeOption<CutefiloniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefiloniveInfo> buildCheckerHook(DeciTreeOption<CutefiloniveInfo> option) {
		List<ModelChecker<CutefiloniveInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefiloniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CutefiloniveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefiloniveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefiloniveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefiloniveCheckCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefiloniveInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefiloniveInfo> option) {
		List<ActionStd<CutefiloniveInfo>> actions = new ArrayList<>();

		ActionStd<CutefiloniveInfo> select = new ActionStdCommom<CutefiloniveInfo>(option, CutefiloniveVisiMergeToSelect.class);
		ActionLazy<CutefiloniveInfo> enforceLChanged = new ActionLazyCommom<CutefiloniveInfo>(option, CutefiloniveVisiEnforceLChanged.class);
		ActionLazy<CutefiloniveInfo> mergeCalonth = new ActionLazyCommom<CutefiloniveInfo>(option, CutefiloniveVisiMergeCalonth.class);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
