package br.com.mind5.payment.systemPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.action.StdSysparDaoSelect;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckRead;

public final class RootSysparSelect extends DeciTreeTemplateReadV2<SysparInfo> {
	
	public RootSysparSelect(DeciTreeOption<SysparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysparInfo> buildCheckerHook(DeciTreeOption<SysparInfo> option) {
		List<ModelCheckerV1<SysparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SysparInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparInfo> option) {
		List<ActionStdV2<SysparInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SysparInfo> select = new StdSysparDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
