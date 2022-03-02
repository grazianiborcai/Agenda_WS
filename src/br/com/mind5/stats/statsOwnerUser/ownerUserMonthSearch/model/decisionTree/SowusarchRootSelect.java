package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action.SowusarchVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker.SowusarchCheckLangu;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker.SowusarchCheckOwner;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker.SowusarchCheckRead;


public final class SowusarchRootSelect extends DeciTreeTemplateWrite<SowusarchInfo> {
	
	public SowusarchRootSelect(DeciTreeOption<SowusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusarchInfo> buildCheckerHook(DeciTreeOption<SowusarchInfo> option) {
		List<ModelChecker<SowusarchInfo>> queue = new ArrayList<>();
		ModelChecker<SowusarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowusarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowusarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowusarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusarchInfo> option) {
		List<ActionStd<SowusarchInfo>> actions = new ArrayList<>();

		ActionStd<SowusarchInfo> select = new ActionStdCommom<SowusarchInfo>(option, SowusarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
