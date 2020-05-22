package br.com.mind5.masterData.sysEnvironment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.action.StdSysenvDaoSelect;
import br.com.mind5.masterData.sysEnvironment.model.checker.SysenvCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysenvSelect extends DeciTreeTemplateReadV2<SysenvInfo> {
	
	public RootSysenvSelect(DeciTreeOption<SysenvInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysenvInfo> buildCheckerHook(DeciTreeOption<SysenvInfo> option) {
		List<ModelCheckerV1<SysenvInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysenvInfo> checker;
		
		checker = new SysenvCheckRead();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysenvInfo>> buildActionsOnPassedHook(DeciTreeOption<SysenvInfo> option) {
		List<ActionStdV1<SysenvInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysenvInfo> select = new StdSysenvDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
