package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.LazySowordRootSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.StdSowordMergeCalonthLtm;


public final class RootSowordSelectLtm extends DeciTreeTemplateWrite<SowordInfo> {
	
	public RootSowordSelectLtm(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();
		ModelChecker<SowordInfo> checker;

		checker = new ModelCheckerDummy<SowordInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> mergeCalonthLtm = new StdSowordMergeCalonthLtm(option);
		ActionLazy<SowordInfo> select = new LazySowordRootSelect(option.conn, option.schemaName);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
