package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.action.StdSysEnvironSelect;
import br.com.mind5.business.masterData.model.checker.SysEnvironCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysEnvironSelect extends DeciTreeTemplateRead<SysEnvironInfo> {
	
	public RootSysEnvironSelect(DeciTreeOption<SysEnvironInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysEnvironInfo> buildCheckerHook(DeciTreeOption<SysEnvironInfo> option) {
		List<ModelCheckerV1<SysEnvironInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysEnvironInfo> checker;
		
		checker = new SysEnvironCheckRead();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysEnvironInfo>> buildActionsOnPassedHook(DeciTreeOption<SysEnvironInfo> option) {
		List<ActionStdV1<SysEnvironInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysEnvironInfo> select = new StdSysEnvironSelect(option);
		
		actions.add(select);
		return actions;
	}
}
