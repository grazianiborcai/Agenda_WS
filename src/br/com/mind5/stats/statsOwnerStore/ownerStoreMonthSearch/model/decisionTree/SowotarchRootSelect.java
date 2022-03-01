package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action.SowotarchVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker.SowotarchCheckLangu;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker.SowotarchCheckOwner;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker.SowotarchCheckRead;


public final class SowotarchRootSelect extends DeciTreeTemplateWrite<SowotarchInfo> {
	
	public SowotarchRootSelect(DeciTreeOption<SowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotarchInfo> buildCheckerHook(DeciTreeOption<SowotarchInfo> option) {
		List<ModelChecker<SowotarchInfo>> queue = new ArrayList<>();
		ModelChecker<SowotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowotarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowotarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotarchInfo> option) {
		List<ActionStd<SowotarchInfo>> actions = new ArrayList<>();

		ActionStd<SowotarchInfo> select = new ActionStdCommom<SowotarchInfo>(option, SowotarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
