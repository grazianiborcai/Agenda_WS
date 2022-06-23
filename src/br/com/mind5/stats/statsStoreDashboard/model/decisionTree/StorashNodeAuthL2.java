package br.com.mind5.stats.statsStoreDashboard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.action.StorashVisiMergeSytotauh;
import br.com.mind5.stats.statsStoreDashboard.model.checker.StorashCheckSytotin;

public final class StorashNodeAuthL2 extends DeciTreeTemplateWrite<StorashInfo> {
	
	public StorashNodeAuthL2(DeciTreeOption<StorashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorashInfo> buildCheckerHook(DeciTreeOption<StorashInfo> option) {
		List<ModelChecker<StorashInfo>> queue = new ArrayList<>();		
		ModelChecker<StorashInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorashCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorashInfo>> buildActionsOnPassedHook(DeciTreeOption<StorashInfo> option) {
		List<ActionStd<StorashInfo>> actions = new ArrayList<>();
		
		ActionStd<StorashInfo> mergeSytotauh = new ActionStdCommom<StorashInfo>(option, StorashVisiMergeSytotauh.class);		
		
		actions.add(mergeSytotauh);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorashInfo>> buildActionsOnFailedHook(DeciTreeOption<StorashInfo> option) {
		List<ActionStd<StorashInfo>> actions = new ArrayList<>();
		
		ActionStd<StorashInfo> success = new ActionStdSuccessCommom<StorashInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
