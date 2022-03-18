package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action.StefiloniveVisiRootSelect;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckLangu;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckOwner;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckRead;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckStore;


public final class StefiloniveRootSelectAuth extends DeciTreeTemplateWrite<StefiloniveInfo> {
	
	public StefiloniveRootSelectAuth(DeciTreeOption<StefiloniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefiloniveInfo> buildCheckerHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ModelChecker<StefiloniveInfo>> queue = new ArrayList<>();		
		ModelChecker<StefiloniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StefiloniveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StefiloniveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StefiloniveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StefiloniveCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefiloniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ActionStd<StefiloniveInfo>> actions = new ArrayList<>();

		ActionStd<StefiloniveInfo> auth = new StefiloniveNodeAuthL1(option).toAction();
		ActionLazy<StefiloniveInfo> select = new ActionLazyCommom<StefiloniveInfo>(option.conn, option.schemaName, StefiloniveVisiRootSelect.class);
		
		auth.addPostAction(select);
		
		actions.add(auth);
		return actions;
	}
}
