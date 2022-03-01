package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action.SowordarchVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.checker.SowordarchCheckLangu;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.checker.SowordarchCheckOwner;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.checker.SowordarchCheckRead;


public final class SowordarchRootSelect extends DeciTreeTemplateWrite<SowordarchInfo> {
	
	public SowordarchRootSelect(DeciTreeOption<SowordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordarchInfo> buildCheckerHook(DeciTreeOption<SowordarchInfo> option) {
		List<ModelChecker<SowordarchInfo>> queue = new ArrayList<>();
		ModelChecker<SowordarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowordarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordarchInfo> option) {
		List<ActionStd<SowordarchInfo>> actions = new ArrayList<>();

		ActionStd<SowordarchInfo> select = new ActionStdCommom<SowordarchInfo>(option, SowordarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
