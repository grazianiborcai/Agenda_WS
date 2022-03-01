package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action.SowotagrVisiDaoDelete;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckExist;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckLangu;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckOwner;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker.SowotagrCheckWrite;

public final class SowotagrRootDelete extends DeciTreeTemplateWrite<SowotagrInfo> {
	
	public SowotagrRootDelete(DeciTreeOption<SowotagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotagrInfo> buildCheckerHook(DeciTreeOption<SowotagrInfo> option) {	
		List<ModelChecker<SowotagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SowotagrInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SowotagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SowotagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SowotagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SowotagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotagrInfo> option) {
		List<ActionStd<SowotagrInfo>> actions = new ArrayList<>();		
		
		ActionStd<SowotagrInfo> delete = new ActionStdCommom<SowotagrInfo>(option, SowotagrVisiDaoDelete.class);	
		
		actions.add(delete);
		return actions;
	}
}
