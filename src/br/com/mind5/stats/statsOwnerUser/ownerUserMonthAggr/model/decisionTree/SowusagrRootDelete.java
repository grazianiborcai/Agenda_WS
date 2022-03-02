package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action.SowusagrVisiDaoDelete;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker.SowusagrCheckExist;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker.SowusagrCheckLangu;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker.SowusagrCheckOwner;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker.SowusagrCheckWrite;

public final class SowusagrRootDelete extends DeciTreeTemplateWrite<SowusagrInfo> {
	
	public SowusagrRootDelete(DeciTreeOption<SowusagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusagrInfo> buildCheckerHook(DeciTreeOption<SowusagrInfo> option) {	
		List<ModelChecker<SowusagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SowusagrInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SowusagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SowusagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SowusagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SowusagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusagrInfo> option) {
		List<ActionStd<SowusagrInfo>> actions = new ArrayList<>();		
		
		ActionStd<SowusagrInfo> delete = new ActionStdCommom<SowusagrInfo>(option, SowusagrVisiDaoDelete.class);	
		
		actions.add(delete);
		return actions;
	}
}
